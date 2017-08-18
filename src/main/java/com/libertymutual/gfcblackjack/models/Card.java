package com.libertymutual.gfcblackjack.models;

public class Card {

	String name;
	int[] value;

	public Card(String name, int[] value) {

		this.name = name;
		this.value = value;
	}

	protected String getName() {
		return name;
	}

	protected int[] getValue() {
		return value;
	}
}