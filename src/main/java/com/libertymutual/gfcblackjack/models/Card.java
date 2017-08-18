package com.libertymutual.gfcblackjack.models;

public class Card {

	String name;
	int[] value;

	public Card(String name, int[] value) {

		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int[] getValue() {
		return value;
	}
}