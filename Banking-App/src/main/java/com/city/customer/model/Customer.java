package com.city.customer.model;

public class Customer {

	
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	public Customer() {
		super();
	}
	public Customer(String customerId, String firstName, String lastName, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "customerId= " + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email;
	}
	
	
}
