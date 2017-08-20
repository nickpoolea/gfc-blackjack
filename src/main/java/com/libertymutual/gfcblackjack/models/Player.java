package com.libertymutual.gfcblackjack.models;

import java.util.Stack;

public class Player {
	
	public Hand hand;
	private int money = 100;
	private boolean stood = false;
	private int bet;
	
	public Player() {
		hand = new Hand();		
	}
	
	public void winBet(double multiplier) {
		money += (bet * multiplier);
	}
	
	public void setBet(int bet) {
		this.bet = bet;
		money -= bet;
	}
	
	public Stack<Card> getHand() {
		return hand.cards;
	}
	
	public int getMoney() {
		return money;
	}
	
	public boolean getStood() {
		return stood;
	}
	
	public void setStood(boolean stood) {
		this.stood = stood;
	}
	
}
