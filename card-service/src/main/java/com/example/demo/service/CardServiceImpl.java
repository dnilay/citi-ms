package com.example.demo.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.model.Card;
import com.example.demo.repo.CardRepository;
@Service
public class CardServiceImpl implements CardService {

	private final CardRepository cardRepository;
	
	
	
	
	public CardServiceImpl(CardRepository cardRepository) {
		super();
		this.cardRepository = cardRepository;
	}

	@Override
	public Card createCard(Card card) {
		// TODO Auto-generated method stub
		card.setCardNumber(UUID.randomUUID().toString());
		return cardRepository.save(card);
	}

	@Override
	public Iterable<Card> getAllCards() {
		// TODO Auto-generated method stub
		return cardRepository.findAll();
	}

}
