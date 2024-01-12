package com.city.loan.repo;

import java.sql.SQLException;
import java.util.List;

import com.city.loan.model.Loan;
import com.city.loan.model.ResponseLoan;

public interface LoanRepository {

	void createLoan(Loan loan) throws SQLException;

	List<ResponseLoan> displayAllLoans() throws SQLException;

}
