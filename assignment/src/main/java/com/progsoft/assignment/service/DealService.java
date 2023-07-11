package com.progsoft.assignment.service;

import java.util.Optional;

import com.progsoft.assignment.entity.Deal;

public interface DealService {

	Optional<Deal> findValidDealByDealId(String dealId);

	void saveDeal(Deal deal);

}
