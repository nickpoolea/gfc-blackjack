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
	
	
	public int getHandValue() {
		cardValues = new int[2];
		
		for (Card card: cards) {
			cardValues[0] += card.getValue()[0];
			cardValues[1] += card.getValue()[1];
		}
		
		if (cardValues[0] != cardValues[1]) {
			hasAce = true;
		}
		
		if (!hasAce) {
			return cardValues[0];
		}
		else if (cardValues[0] > 21) {
			return cardValues[1];
		}
		else return cardValues[0];
	}
	
	
	public boolean checkBust() {
		
		if (getHandValue()> 21) {
			return true;
		}
		else return false;
	}
	
	
	public boolean checkBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		else return false;
	}
	
	
	public void clearHand() {
		while (cards.size() > 0){
			cards.pop();
		}
	}
	
}
