package com.libertymutual.gfcblackjack.models;

import java.util.Stack;

public class Hand {

	public Stack<Card> cards;
	public boolean hasAce = false;
	public int[] cardValues;
	
	public Hand() {
		cards = new Stack<Card>();
	}
	
	public void addCards(Stack<Card> cardsToAdd) {
		for (Card c: cardsToAdd) {
			cards.push(c);

		}
	}
	
	public int[] getCardValues() {
		cardValues = new int[2];
		for (Card card: cards) {
			cardValues[0] += card.getValue()[0];
			cardValues[1] += card.getValue()[1];
		}
		
		if (cardValues[0] != cardValues[1]) {
			hasAce = true;
		}
		
		return cardValues;
	}
	
}
