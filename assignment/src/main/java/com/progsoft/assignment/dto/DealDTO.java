package com.progsoft.assignment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.progsoft.assignment.entity.Deal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DealDTO {

	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

	private String dealId;

	private String fromCurrency;

	private String toCurrency;

	private String dateTime;

	private String amount;

	public static Deal toDeal(DealDTO dealDto, String fileName) {
		Deal deal = new Deal();
		deal.setDealId(dealDto.getDealId());
		deal.setFromCurrency(CurrencyCode.valueOf(dealDto.getFromCurrency()));
		deal.setToCurrency(CurrencyCode.valueOf(dealDto.getToCurrency()));
		deal.setDateTime(LocalDateTime.parse(dealDto.getDateTime(), FORMATTER));
		deal.setAmount(new BigDecimal(dealDto.getAmount()));
		deal.setFileName(fileName);
		return deal;
	}

}
