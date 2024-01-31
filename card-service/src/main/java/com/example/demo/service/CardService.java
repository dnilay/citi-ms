package com.example.demo.service;

import com.example.demo.model.Card;

public interface CardService {
	Card createCard(Card card);
	Iterable<Card> getAllCards();

}
