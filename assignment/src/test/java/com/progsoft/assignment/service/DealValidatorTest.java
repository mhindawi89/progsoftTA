package com.progsoft.assignment.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.progsoft.assignment.dto.DealDTO;

@RunWith(SpringRunner.class)
public class DealValidatorTest {

	private DealValidtorService dealValidtorService = new DealValidtorServiceImpl();

	@Test
	public void testIsisValid_inisValid() {

		{ // all values are null
			DealDTO DealDTO = new DealDTO();

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

		{ // amount is blank/empty/null
			DealDTO DealDTO = new DealDTO();
			DealDTO.setAmount("");
			DealDTO.setDealId("1");
			DealDTO.setDateTime("2017-11-03 01:57:59");
			DealDTO.setFromCurrency("PHP");
			DealDTO.setToCurrency("AED");

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

		{ // amount inisValid decimal format
			DealDTO DealDTO = new DealDTO();
			DealDTO.setAmount("$1000.00");
			DealDTO.setDealId("1");
			DealDTO.setDateTime("2017-11-03 01:57:59");
			DealDTO.setFromCurrency("PHP");
			DealDTO.setToCurrency("AED");

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

		{ // deal id is blank/empty/null
			DealDTO DealDTO = new DealDTO();
			DealDTO.setAmount("1000.00");
			DealDTO.setDealId("");
			DealDTO.setDateTime("2017-11-03 01:57:59");
			DealDTO.setFromCurrency("PHP");
			DealDTO.setToCurrency("AED");

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

		{ // date time is blank/empty/null
			DealDTO DealDTO = new DealDTO();
			DealDTO.setAmount("1000.00");
			DealDTO.setDealId("11");
			DealDTO.setDateTime("");
			DealDTO.setFromCurrency("PHP");
			DealDTO.setToCurrency("AED");

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

		{ // date time inisValid format
			DealDTO DealDTO = new DealDTO();
			DealDTO.setAmount("1000.00");
			DealDTO.setDealId("11");
			DealDTO.setDateTime("2017/11/03 01:57:59");
			DealDTO.setFromCurrency("PHP");
			DealDTO.setToCurrency("AED");

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

		{ // from currency is empty/blank/null
			DealDTO DealDTO = new DealDTO();
			DealDTO.setAmount("1000.00");
			DealDTO.setDealId("11");
			DealDTO.setDateTime("2017-11-03 01:57:59");
			DealDTO.setFromCurrency("");
			DealDTO.setToCurrency("AED");

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

		{ // from currency code inisValid
			DealDTO DealDTO = new DealDTO();
			DealDTO.setAmount("1000.00");
			DealDTO.setDealId("11");
			DealDTO.setDateTime("2017-11-03 01:57:59");
			DealDTO.setFromCurrency("*#&#");
			DealDTO.setToCurrency("AED");

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

		{ // to currency is empty/blank/null
			DealDTO DealDTO = new DealDTO();
			DealDTO.setAmount("1000.00");
			DealDTO.setDealId("11");
			DealDTO.setDateTime("2017-11-03 01:57:59");
			DealDTO.setFromCurrency("AED");
			DealDTO.setToCurrency("");

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

		{ // from currency code inisValid
			DealDTO DealDTO = new DealDTO();
			DealDTO.setAmount("1000.00");
			DealDTO.setDealId("11");
			DealDTO.setDateTime("2017-11-03 01:57:59");
			DealDTO.setFromCurrency("USD");
			DealDTO.setToCurrency("*$($");

			assertFalse(dealValidtorService.isValid(DealDTO));
		}

	}

	@Test
	public void testIsisValid_isValid() {

		DealDTO DealDTO = new DealDTO();
		DealDTO.setAmount("1000.00");
		DealDTO.setDealId("0101011");
		DealDTO.setDateTime("2017-11-03 01:57:59");
		DealDTO.setFromCurrency("PHP");
		DealDTO.setToCurrency("AED");

		assertTrue(dealValidtorService.isValid(DealDTO));
	}

}
