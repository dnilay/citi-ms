package com.rest.loans.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.loans.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	List<Loan> findByType(String type);
}
