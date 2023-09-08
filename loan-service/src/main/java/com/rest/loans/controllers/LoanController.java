package com.rest.loans.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.loans.client.RateClient;
import com.rest.loans.dtos.InterestRate;
import com.rest.loans.entities.Loan;
import com.rest.loans.error.ErrorResponseModel;
import com.rest.loans.repositories.LoanRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class LoanController {

	private final LoanRepository loanRepository;
	private final RateClient rateClient;

	@GetMapping(path = "/loans")
	@CircuitBreaker(name = "loan-service", fallbackMethod = "getDefaultLoans")
	public ResponseEntity<?> getLoansByType(@RequestParam("type") String type) {

		InterestRate interestRate = rateClient.findRateByType(type.toUpperCase());

		List<Loan> loanList = null;

		loanList = loanRepository.findByType(type.toUpperCase());
		System.out.println(loanList);
		for (Loan loan : loanList) {
			loan.setInterest(loan.getAmount() * (interestRate.getRateValue() / 100));
			loanRepository.save(loan);
		}
		return ResponseEntity.ok(interestRate);
	}

	public ResponseEntity<?> getDefaultLoans(Exception e) {
		ErrorResponseModel model = new ErrorResponseModel();
		model.setErrorCode(HttpStatus.BAD_REQUEST.value());
		model.setErrorTime(System.currentTimeMillis());
		model.setMessage("rate-service is down please try after some time...!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(model);

	}
}
