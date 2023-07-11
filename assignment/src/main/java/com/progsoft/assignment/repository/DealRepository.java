package com.progsoft.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progsoft.assignment.entity.Deal;

@Repository
public interface DealRepository extends JpaRepository<Deal, String> { 
	
	Optional<Deal> findByDealId(String dealId);

}
