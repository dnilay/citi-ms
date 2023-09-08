package com.rest.loans;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.rest.loans.entities.Loan;
import com.rest.loans.repositories.LoanRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class LoanServiceApplication {

	@Autowired
	private LoanRepository loanRepository;

	public static void main(String[] args) {
		SpringApplication.run(LoanServiceApplication.class, args);
	}

	@PostConstruct
	public void setupData() {
		loanRepository
				.saveAll(Arrays.asList(Loan.builder().id(1).type("PERSONAL").amount(200000.0).interest(0.0).build(),
						Loan.builder().id(2).type("HOUSING").amount(6000000.0).interest(0.0).build(),
						Loan.builder().id(3).type("PERSONAL").amount(100000.0).interest(0.0).build()));
	}
}
