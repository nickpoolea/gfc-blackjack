package com.libertymutual.gfcblackjack.models;

import org.springframework.web.servlet.ModelAndView;

public class Game {
	
	public Deck deck;
	public Player player;
	public Player dealer;
	public ModelAndView mvGame;

	public Game() {
	
		deck = new Deck();
		deck.createDeck();
		deck.shuffleDeck(deck.cards);		
		player = new Player();
		dealer = new Player();
	}
	
	
	public void dealCards(Player player, int numCards, boolean isHidden) {
		player.hand.addCards(deck.getCards(numCards, isHidden));
		player.hand.getCardValues();
		mvGame = new ModelAndView();
		
	}
	
	public ModelAndView getModelAndView() {
		mvGame.setViewName(checkGame());
		mvGame.addObject("player", player);
		mvGame.addObject("dealer", dealer);
		mvGame.addObject("playerHand", player.hand);
		mvGame.addObject("dealerHand", dealer.hand);
		mvGame.addObject("playerCards", player.hand.cards);
		mvGame.addObject("dealerCards", dealer.hand.cards);
		mvGame.addObject("deck", deck);
		
		
		return mvGame;
	}
	
	public String checkGame() {
		
		if (player.getMoney() <= 0) {
			return "end";
		}
		if (player.hand.checkBust()) {
			return "bust";
		}
		else if (player.hand.checkBlackjack() && !dealer.hand.checkBlackjack() ) {
			player.winBet(2.5);
			return "blackjack";
		}
		else if (player.hand.checkBlackjack() && dealer.hand.checkBlackjack() ) {
			return "blackjack";
		}
		else if (!player.hand.checkBust() && dealer.hand.checkBust()) {
			player.winBet(2);
			return "win";
		}
		else if ((player.hand.getCardValues() > dealer.hand.getCardValues()) && player.getStood()) {
			player.winBet(2);
			return "win";
		}
		else if(player.getStood()) {
			return "lose";
		}
		else return "play";
	}
	
	public void autoDeal(Player player) {
		while (player.hand.getCardValues() < 17 || player.hand.getCardValues() < 17) {
			dealCards(player, 1, false);
		}
	}
}
