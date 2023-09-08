package com.rest.rates.services;

import org.springframework.stereotype.Service;

import com.rest.rates.entities.Rate;
import com.rest.rates.repositories.RateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RateService {

	private final RateRepository repository;

	public Rate getRateByType(String type) {
		return repository.findByType(type).orElseThrow(() -> new RuntimeException("Rate Not Found: " + type));
	}
}
