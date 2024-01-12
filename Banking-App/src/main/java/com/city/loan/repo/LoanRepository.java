package com.city.loan.repo;

import java.sql.SQLException;
import java.util.List;

import com.city.loan.model.Loan;

public interface LoanRepository {

	void createLoan(Loan loan) throws SQLException;

	List<Loan> displayAllLoans() throws SQLException;
	
	void updateLoanByLoanId(int loanId) throws SQLException;
	void deleteLoanAccountById(int loanId) throws SQLException;

}
