package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CityLoanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityLoanServiceApplication.class, args);
	}

	@GetMapping("/status")
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("loan-service is up");
	}
}
