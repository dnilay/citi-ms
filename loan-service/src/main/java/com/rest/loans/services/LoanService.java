/*
 * package com.rest.loans.services;
 * 
 * import com.rest.loans.dtos.InterestRate; import com.rest.loans.entities.Loan;
 * import com.rest.loans.repositories.LoanRepository; import
 * io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.*; import org.springframework.stereotype.Service;
 * import org.springframework.web.client.RestTemplate;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * @Service public class LoanService {
 * 
 * @Autowired private LoanRepository loanRepository;
 * 
 * @Autowired private RestTemplate restTemplate;
 * 
 * private static final String SERVICE_NAME = "loan-service";
 * 
 * private static final String RATE_SERVICE_URL =
 * "http://localhost:9000/api/rates/";
 * 
 * //@CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "getDefaultLoans")
 * public List<Loan> getAllLoansByType(String type) {
 * 
 * }
 * 
 * 
 * 
 * public List<Loan> getDefaultLoans(Exception e) { return new ArrayList<>(); }
 * }
 */