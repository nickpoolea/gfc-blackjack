package com.libertymutual.gfcblackjack.models;

public class Card {

	public String name;
	public int[] value;
	public boolean isHidden;

	public Card(String name, int[] value, boolean isHidden) {
		
		this.isHidden = isHidden;
		this.name = name;
		this.value = value;
	}

	public String getName() {
		if (isHidden) {
			return "?";
		}
		else return name;
	}

	public int[] getValue() {
		return value;
	}
}