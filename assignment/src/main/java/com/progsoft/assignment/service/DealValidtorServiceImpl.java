package com.progsoft.assignment.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.progsoft.assignment.dto.CurrencyCode;
import com.progsoft.assignment.dto.DealDTO;

@Service("dealValidatorService")
public class DealValidtorServiceImpl implements DealValidtorService {

	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

	@Override
	public boolean isValid(DealDTO dealDto) {
		if (StringUtils.isEmpty(dealDto.getDealId())) {
			return false;
		}

		if (StringUtils.isEmpty(dealDto.getToCurrency())) {
			return false;
		} else {
			if (!CurrencyCode.ISO_CURRENCY_CODES.contains(dealDto.getToCurrency())) {
				return false;
			}
		}

		if (StringUtils.isEmpty(dealDto.getFromCurrency())) {
			return false;
		} else {
			if (!CurrencyCode.ISO_CURRENCY_CODES.contains(dealDto.getFromCurrency())) {
				return false;
			}
		}

		if (StringUtils.isEmpty(dealDto.getDateTime())) {
			return false;
		} else {
			try {
				LocalDateTime.parse(dealDto.getDateTime(), FORMATTER);
			} catch (DateTimeParseException e) {
				return false;
			}
		}

		if (StringUtils.isEmpty(dealDto.getAmount())) {
			return false;
		} else {
			try {
				new BigDecimal(dealDto.getAmount());
			} catch (NumberFormatException e) {
				return false;
			}
		}

		return true;
	}

}
