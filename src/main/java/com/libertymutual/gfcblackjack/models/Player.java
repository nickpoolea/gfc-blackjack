package com.libertymutual.gfcblackjack.models;

public class Player {
	
	public Hand hand;
	public int money = 100;
	public boolean hasStood = false;

	public Player() {
		hand = new Hand();		
	}
	
	
	public int getMoney() {
		return money;
	}
	
}
