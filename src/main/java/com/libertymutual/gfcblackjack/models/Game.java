package com.libertymutual.gfcblackjack.models;

import org.springframework.web.servlet.ModelAndView;

public class Game {
	
	public Deck deck;
	public Player player;
	public Player dealer;
	public ModelAndView mv;

	public Game() {
	
		deck = new Deck();
		deck.createDeck();
		deck.shuffleDeck();
				
		player= new Player();
		dealer = new Player();
	}
	
	public void dealCards(Player player, int numCards) {
		player.hand.addCards(deck.getCards(numCards));
		player.hand.getCardValues();
		mv = new ModelAndView();
		
	}
	
	public ModelAndView getModelAndView() {
		mv.setViewName(checkGame());
		mv.addObject("playerCards", player.hand.cards);
		mv.addObject("dealerCards", dealer.hand.cards);
		mv.addObject("playerValues", player.hand.cardValues[0]);
		mv.addObject("dealerValues", dealer.hand.cardValues[0]);
		
		if (player.hand.hasAce) {
			mv.addObject("playerValuesOther", player.hand.cardValues[1]);
		}
		else if (dealer.hand.hasAce ) {
			mv.addObject("dealerValuesOther", dealer.hand.cardValues[1]);
		}
		return mv;
	}
	
	public String checkGame() {
		
		if (player.hand.checkBust()) {
			return "bust";
		}
		else if (player.hand.checkBlackjack() ) {
			return "blackjack";
		}
		else if((player.hand.getCardValues()[0] > dealer.hand.getCardValues()[0]) && player.hasStood) {
			return "win";
		}
		else if(player.hasStood) {
			return "lose";
		}
		else return "play";
	}
	
	public void autoDealer() {
		while (dealer.hand.getCardValues()[0] < 17 || dealer.hand.getCardValues()[1] < 17) {
			dealCards(dealer, 1);
		}
	}
}
