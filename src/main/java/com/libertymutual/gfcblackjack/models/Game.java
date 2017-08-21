package com.libertymutual.gfcblackjack.models;

import java.util.Stack;

import org.springframework.web.servlet.ModelAndView;

public class Game {
	
	public Deck deck;
	public Player player;
	public Player dealer;
	private ModelAndView mvGame;
	private boolean roundIsOver;
	String playerGameStatus;


	public Game() {
	
		deck = new Deck();
		deck.createDeck();
		deck.shuffleDeck(deck.cards);		
		player = new Player();
		dealer = new Player();
		mvGame = new ModelAndView();
	}
	
	
	public void dealCards(Player player, int numCards, boolean isHidden) {
		player.hand.addCards(deck.getCards(numCards, isHidden));
		player.hand.getHandValue();
	}
	
	
	public ModelAndView getModelAndView() {
		checkAndHandleRoundStatus();
		checkIfPlayerWon();
		mvGame.setViewName(returnGameView());
		mvGame.addObject("player", player);
		mvGame.addObject("dealer", dealer);
		mvGame.addObject("playerHand", player.hand);
		mvGame.addObject("dealerHand", dealer.hand);
		mvGame.addObject("playerCards", player.hand.cards);
		mvGame.addObject("dealerCards", dealer.hand.cards);
		mvGame.addObject("deck", deck);
		mvGame.addObject("doubleDown", checkDoubleDown());
		return mvGame;
	}
	
	private boolean checkDoubleDown() {
		if (player.hand.cards.size() == 2 && (player.getMoney() >= player.getBet())) {
			return true;
		}
		else return false;
	}
	
	public void unhideCards(Stack<Card> cards) {
		int stackSize = cards.size();
		for (int i = 0; i < stackSize ; i++) {
			cards.get(i).isHidden = false;
		}
		
	}
	
	private void checkAndHandleRoundStatus() {
		
		if((!player.hand.checkBust() && player.getStoodStatus()) || player.hand.checkBlackjack()) {
			autoDeal(dealer);
			unhideCards(dealer.hand.cards);
			player.setBettingStatus(false);
			roundIsOver = true;
		} 
		else if (player.hand.checkBust()) {
			unhideCards(dealer.hand.cards);
			player.setBettingStatus(false);
			roundIsOver = true;
		} 
		else roundIsOver = false;
	}
	
	
	public void checkIfPlayerWon() {
		
		if(player.hand.checkBust()) {
			playerGameStatus = "bust";
		}
		else if (player.hand.checkBlackjack() && !dealer.hand.checkBlackjack()) {
			player.winBet(2.5);
			playerGameStatus =  "blackjack";
		}
		else if (player.hand.checkBlackjack() && dealer.hand.checkBlackjack()) {
			player.winBet(1);
			playerGameStatus =  "tie";
		}
		else if (dealer.hand.checkBust()) {
			player.winBet(2);
			playerGameStatus =  "win";
		}
		
		else if (player.getStoodStatus()) {
			
			if (player.hand.getHandValue() == dealer.hand.getHandValue()) {
				player.winBet(1);
				playerGameStatus =  "tie";
			}
			else if (player.hand.getHandValue() > dealer.hand.getHandValue()) {
				player.winBet(2);
				playerGameStatus =  "win";
			}
			else playerGameStatus = "lose";
		}
		else playerGameStatus = "play";
	}
	
	public String returnGameView() {		
		if (!player.getBettingStatus() && player.getMoney() <= 0) {
			return "end";
		}
		else return playerGameStatus;
	}
	
	
	public void autoDeal(Player player) {
		while (player.hand.getHandValue() < 17 || player.hand.getHandValue() < 17) {
			dealCards(player, 1, false);
		}
	}
	
	public ModelAndView doubleDownHandler() {
		player.setBet(player.getBet(), true);
		dealCards(player, 1, false);
		player.setStood(true);
		return getModelAndView();
	}
	
}
