package com.libertymutual.gfcblackjack.models;

public class Player {
	
	public Hand hand;
	public int money = 100;

	public Player() {
		hand = new Hand();		
	}
	
	
	public int getMoney() {
		return money;
	}
}
