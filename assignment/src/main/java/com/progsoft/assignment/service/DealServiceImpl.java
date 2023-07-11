package com.progsoft.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progsoft.assignment.entity.Deal;
import com.progsoft.assignment.repository.DealRepository;

@Service("dealService")
public class DealServiceImpl implements DealService {
	
	@Autowired
	private DealRepository dealRepository;

	@Override
	public Optional<Deal> findValidDealByDealId(String dealId) {
		return dealRepository.findByDealId(dealId);
	}

	@Override
	public void saveDeal(Deal deal) {
		dealRepository.save(deal);
	}

}
