package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Card;
import com.example.demo.service.CardService;

@RestController
@RequestMapping("/cards")
public class CardApi {
	
	private final CardService cardService;

	public CardApi(CardService cardService) {
		super();
		this.cardService = cardService;
	}

	@PostMapping
	public ResponseEntity<Card> createACard(@RequestBody Card card)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(cardService.createCard(card));
	}
	@GetMapping
	public ResponseEntity<Iterable<Card>> displayAllAvailableCards()
	{
		return ResponseEntity.ok(cardService.getAllCards());
	}

}
