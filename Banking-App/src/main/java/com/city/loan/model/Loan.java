package com.city.loan.model;

public class Loan {
	
	private int loanId;
	private LoanType loanType;
	private String customerId;
	public Loan() {
		super();
	}
	
	
	public Loan(LoanType loanType, String customerId) {
		super();
		this.loanType = loanType;
		this.customerId = customerId;
	}


	public Loan(int loanId, LoanType loanType, String customerId) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.customerId = customerId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public LoanType getLoanType() {
		return loanType;
	}
	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "loanId=" + loanId + ", loanType=" + loanType + ", customerId=" + customerId;
	}
	

}
