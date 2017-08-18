package com.libertymutual.gfcblackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.libertymutual.gfcblackjack.models.Card;
import com.libertymutual.gfcblackjack.models.Deck;
import com.libertymutual.gfcblackjack.models.Game;

@SpringBootApplication
public class GfcBlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(GfcBlackjackApplication.class, args);
		
//		Game game = new Game();
//		game.dealCards(game.player, 2);
//		
//		for (Card c: game.player.hand.cards) {
//			System.out.println(c.getName());
//		}
	}

}
