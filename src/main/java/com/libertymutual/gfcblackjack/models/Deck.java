package com.libertymutual.gfcblackjack.models;

import java.util.Collections;
import java.util.Stack;

public class Deck {

	Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
	}

	public Stack<Card> createDeck() {
		String[] suits = { "Hearts", "Spades", "Clubs", "Diamonds" };
		String[] faceCards = { "King", "Queen", "Jack" };

		// Loop through the suits.
		for (int i = 0; i < suits.length; i++) {

			// Create the numeric cards.
			for (int j = 2; j <= 10; j++) {
				int[] valueArray = new int[] { j, j };
				deck.push(new Card(j + " of " + suits[i], valueArray));
			}

			// Create the face cards.
			for (int j = 0; j < faceCards.length; j++) {
				int[] valueArray = { 10, 10 };
				deck.push(new Card(faceCards[j] + " of " + suits[i], valueArray));
			}

			// Create the aces
			int[] valueArray = { 11, 1 };
			deck.push(new Card("Ace" + " of " + suits[i], valueArray));
		}
		
		return deck;
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	public void printDeck() {
		System.out.println("Cards-------------");
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i).getName() + " " 
							 + deck.get(i).getValue()[0] 
						     + " " + deck.get(i).getValue()[1]);
		}
	}
		
	public Stack<Card> getCards(int numCards) {
		Stack<Card> cards = new Stack<Card>();
		for (int i = 0; i < numCards; i++) {
			cards.push(deck.pop());
		}
		
		return cards;
	
		
	}

}
