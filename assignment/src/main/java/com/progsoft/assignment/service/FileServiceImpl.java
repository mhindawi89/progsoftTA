package com.progsoft.assignment.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.progsoft.assignment.dto.DealDTO;
import com.progsoft.assignment.exception.FileEmptyException;
import com.progsoft.assignment.exception.FileTypeExceptionFormat;
import com.progsoft.assignment.exception.FileUploadException;

@Service("fileService")
public class FileServiceImpl implements FileService {

	private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

	public static String TYPE = "text/csv";

	@Autowired
	private DealService dealService;

	@Autowired
	private DealValidtorService dealValidtorService;

	@Override
	public void uploadDealsFile(MultipartFile file) throws FileEmptyException, FileTypeExceptionFormat{
		String fileName = file.getOriginalFilename();
		log.info("Import File Request. File Name: {}", fileName);

		if (file.isEmpty()) {
			throw new FileEmptyException(String.format("file is empty, please check it. File Name: {}", fileName));
		}
		
		if(!file.getContentType().equals(TYPE)) {
			throw new FileTypeExceptionFormat(String.format("file is empty, please check it. File Name: {}", fileName));
		}

		Reader reader = null;

		try {

			reader = new InputStreamReader(file.getInputStream());
			final Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);

			for (CSVRecord record : records) {
				final DealDTO dealDto = new DealDTO();
				dealDto.setDealId(record.get(Headers.DEAL_ID));
				dealDto.setFromCurrency(record.get(Headers.FROM_CURRENCY));
				dealDto.setToCurrency(record.get(Headers.TO_CURRENCY));
				dealDto.setDateTime(record.get(Headers.TIMESTAMP));
				dealDto.setAmount(record.get(Headers.AMOUNT));

				if (dealValidtorService.isValid(dealDto)) {
					if (dealService.findValidDealByDealId(dealDto.getDealId()).isPresent()) {
						log.info("deal already exist no need to add it again, deal Id : {}", dealDto.getDealId());
					} else {
						dealService.saveDeal(DealDTO.toDeal(dealDto, fileName));
						log.info("add new deal to DB, Deal Id : {}", dealDto.getDealId());
					}
				}
			}
		} catch (Exception e) {
			throw new FileUploadException("Error importing deals.", e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				log.error("Error closing the File Reader.");
			}
		}
	}

	private enum Headers {
		DEAL_ID, FROM_CURRENCY, TO_CURRENCY, TIMESTAMP, AMOUNT
	}
}
