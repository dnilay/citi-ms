package com.city.loan.model;

public enum LoanType {
	
	HOUSING_LOAN("HL"),
	CAR_LOAN("CL"),
	PERSONAL_LOAN("PL"),
	MEDICAL_LOAN("ML");
	private String lType;

	private LoanType(String lType) {
		this.lType = lType;
	}

	public String getlType() {
		return lType;
	}

	public void setlType(String lType) {
		this.lType = lType;
	}
	


	
	
	

}
