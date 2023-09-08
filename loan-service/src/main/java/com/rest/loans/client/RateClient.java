package com.rest.loans.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rest.loans.dtos.InterestRate;

@FeignClient(name = "RATE-SERVICE")
public interface RateClient {
	@GetMapping("/api/rates/{type}")
	InterestRate findRateByType(@PathVariable("type") String type);

}
