package com.libertymutual.gfcblackjack.models;

import java.util.Stack;

public class Hand {

	public Stack<Card> cards;
	
	public Hand() {
		cards = new Stack<Card>();
	}
	
	public void addCard(Stack<Card> cardsToAdd) {
		for (Card c: cardsToAdd) {
			this.cards.push(c);

		}
	}
	
	public int[] getCardValue() {
		int[] cardValues = new int[2];
		for (Card card: cards) {
			cardValues[0] += card.getValue()[0];
			cardValues[1] += card.getValue()[1];
		}
		
		return cardValues;
	}
	
}
