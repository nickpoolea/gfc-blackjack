package com.libertymutual.gfcblackjack.models;

import java.util.Collections;
import java.util.Stack;

public class Deck {

	Stack<Card> cards;
	Stack<Card> usedCards;

	public Deck() {
		cards = new Stack<Card>();
		usedCards = new Stack<Card>();
	}

	
	public Stack<Card> createDeck() {
		String[] suits = { "Hearts", "Spades", "Clubs", "Diamonds" };
		String[] faceCards = { "King", "Queen", "Jack" };

		// Loop through the suits.
		for (int i = 0; i < suits.length; i++) {

			// Create the numeric cards.
			for (int j = 2; j <= 10; j++) {
				int[] valueArray = new int[] { j, j };
				cards.push(new Card(j + " of " + suits[i], valueArray, false));
			}

			// Create the face cards.
			for (int j = 0; j < faceCards.length; j++) {
				int[] valueArray = { 10, 10 };
				cards.push(new Card(faceCards[j] + " of " + suits[i], valueArray, false));
			}

			// Create the aces
			int[] valueArray = { 11, 1 };
			cards.push(new Card("Ace" + " of " + suits[i], valueArray, false));
		}
		
		return cards;
	}
	

	public void shuffleDeck(Stack<Card> cards) {
		Collections.shuffle(cards);
	}

		
	public Stack<Card> getCards(int numCards, boolean isHidden) {
		Stack<Card> cards = new Stack<Card>();
		
		for (int i = 0; i < numCards; i++) {
			if (this.cards.size() == 0) {
				repopulateDeck();
			}
		
			Card usedCard = this.cards.pop();
			usedCard.isHidden = isHidden;
			cards.push(usedCard);
			usedCards.push(usedCard);
		}
		
		return cards;
	}
	
	
	private void repopulateDeck() {
		shuffleDeck(usedCards);
		while (usedCards.size() > 0) {
			cards.push(usedCards.pop());
		}
	}
	
	
	public int getSize() {
		return cards.size();
	}

}
