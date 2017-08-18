package com.libertymutual.gfcblackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.libertymutual.gfcblackjack.models.Deck;

@SpringBootApplication
public class GfcBlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(GfcBlackjackApplication.class, args);
		
		Deck deck = new Deck();
		deck.createDeck();
		deck.shuffleDeck();
		deck.printDeck();
		
	}
}
