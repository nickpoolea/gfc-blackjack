package com.libertymutual.gfcblackjack.models;


public class GamePlayer extends Player {
	
	public Hand hand;
	private int money = 100;
	private boolean stood = false;
	private int bet;
	private boolean isBetting = false;
	

	public void winBet(double multiplier) {
		money += (bet * multiplier);
	}
	
	public void setBet(int bet) {
		if (bet > money) {
			this.bet = money;
		}
		else this.bet = bet;
		money -= this.bet;
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
