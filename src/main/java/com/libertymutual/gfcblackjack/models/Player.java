package com.libertymutual.gfcblackjack.models;


public class Player {
	
	public Hand hand;
	private int money = 100;
	private boolean stood = false;
	private int bet;
	private boolean isBetting = false;
	
	public Player() {
		hand = new Hand();
	}

	public void winBet(double multiplier) {
		money += (bet * multiplier);
	}
	
	public void setBet(int bet, boolean doubleDown) {
		if (doubleDown) {
			this.bet *= 2;
		}
		else if (bet > money) {
			this.bet = money;
		}
		else this.bet = bet;
		money -= bet;
		isBetting = true;
	}
	
	
	public int getMoney() {
		return money;
	}
	
	public boolean getStoodStatus() {
		return stood;
	}
	
	public void setStood(boolean stood) {
		this.stood = stood;
	}
	
	public void setBettingStatus(boolean isBetting) {
		this.isBetting = isBetting;
	}
	
	public boolean getBettingStatus() {
		return isBetting;
	}
	
	public int getBet() {
		return bet;
	}
	
}
