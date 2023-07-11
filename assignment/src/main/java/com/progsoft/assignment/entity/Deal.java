package com.progsoft.assignment.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.progsoft.assignment.dto.CurrencyCode;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Deal")
@Getter
@Setter
public class Deal { 
	
	@Column(name = "deal_id", nullable = false, unique = true)
    private String dealId;

    @Column(name = "from_currency")
    @Enumerated(EnumType.STRING)
    private CurrencyCode fromCurrency;

    @Column(name = "to_currency")
    @Enumerated(EnumType.STRING)
    private CurrencyCode toCurrency;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "amount")
    private BigDecimal amount;
    
    @Column(name = "file_name")
    private String fileName;


}
