package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "card_table")
public class Card {
	@Id
	@Column(name = "card_number",unique = true, nullable = false)
	private String cardNumber;
	@Column(name = "name_on_card",nullable = false)
	private String cardHolderName;
	@Column(name = "card_type",nullable = false)
	private String cardType;
	@Column(name = "available_balance",nullable = false)
	private double availableBalance;
	@Column(name = "active_status",nullable = false)
	@JsonProperty
	private boolean isActive;
	public Card() {
		super();
	}
	 
	public Card(String cardHolderName, String cardType, double availableBalance, boolean isActive) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardType = cardType;
		this.availableBalance = availableBalance;
		this.isActive = isActive;
	}

	public Card(String cardNumber, String cardHolderName, String cardType, double availableBalance, boolean isActive) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cardType = cardType;
		this.availableBalance = availableBalance;
		this.isActive = isActive;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", cardType=" + cardType
				+ ", availableBalance=" + availableBalance + ", isActive=" + isActive + "]";
	}
	
	

}
