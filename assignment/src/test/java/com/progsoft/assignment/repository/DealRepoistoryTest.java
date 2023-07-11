package com.progsoft.assignment.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.progsoft.assignment.entity.Deal;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DealRepoistoryTest {

	@Autowired
	private DealRepository dealRepository;

	@Autowired
	protected TestEntityManager testEntityManager;

	@Test
	public void testFindByDealId() {

		Deal deal = new Deal();
		deal.setDateTime(LocalDateTime.now());
		deal.setAmount(new BigDecimal(0));
		deal.setFromCurrency(com.progsoft.assignment.dto.CurrencyCode.AED);
		deal.setToCurrency(com.progsoft.assignment.dto.CurrencyCode.AFN);
		deal.setFileName("filename.csv");
		deal.setDealId("0001");

		testEntityManager.persistAndFlush(deal);

		Optional<Deal> findDeal = dealRepository.findById("0001");

		assertEquals(findDeal.get(), deal);
		assertEquals(findDeal.get().getDealId(), deal.getDealId());
	}

}
