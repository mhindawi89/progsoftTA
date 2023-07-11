package com.progsoft.assignment.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import com.progsoft.assignment.entity.Deal;
import com.progsoft.assignment.repository.DealRepository;

@RunWith(MockitoJUnitRunner.class)
public class DealServiceTest {
	
	@Mock
	private DealRepository dealRepository;
	
	@InjectMocks
	private DealService dealService = new DealServiceImpl();
	
	@Test
    public void testFIndValidDealByDealId() {

        Deal testDeal = new Deal();

        when(dealRepository.findByDealId(anyString()).get()).thenReturn(testDeal);

        Optional<Deal> returnedDeal = dealService.findValidDealByDealId("deal_id");

        verify(dealRepository, atLeastOnce()).findByDealId(eq("deal_id"));
        assertEquals(returnedDeal, is(testDeal));
    }
	
	@Test
    public void testSaveDeal() {
		
		Deal testDeal = new Deal();
		
		dealService.saveDeal(testDeal);
		
		 verify(dealRepository, atLeastOnce()).save(eq(testDeal));
	}
}
