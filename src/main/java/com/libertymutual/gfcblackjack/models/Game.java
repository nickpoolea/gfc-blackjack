package com.libertymutual.gfcblackjack.models;

public class Game {
	
	public Deck deck;
	public Player player;
	public Player dealer;

	public Game() {
	
		deck = new Deck();
		deck.createDeck();
		deck.shuffleDeck();
				
		player= new Player();
		dealer = new Player();
	}
	
	public void dealCards(Player player, int numCards) {
		player.hand.addCard(deck.getCards(numCards));
		
	}
}
