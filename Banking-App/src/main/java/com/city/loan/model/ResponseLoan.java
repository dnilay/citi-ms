package com.city.loan.model;

public class ResponseLoan {
	
	private int loanId;
	private String loanType;
	private String customerId;
	public ResponseLoan() {
		super();
	}
	public ResponseLoan(int loanId, String loanType, String customerId) {
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
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
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
		return "ResponseLoan [loanId=" + loanId + ", loanType=" + loanType + ", customerId=" + customerId + "]";
	}
	
	

}
