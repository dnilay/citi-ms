package com.city.account;

public class Account {
	
	private int accountNumber;
	private String accountHolderName;
	private int amountAvailable;
	public Account() {
		super();
	}
	public Account(int accountNumber, String accountHolderName, int amountAvailable) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.amountAvailable = amountAvailable;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public int getAmountAvailable() {
		return amountAvailable;
	}
	public void setAmountAvailable(int amountAvailable) {
		this.amountAvailable = amountAvailable;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", amountAvailable=" + amountAvailable + "]";
	}
	
	

}
