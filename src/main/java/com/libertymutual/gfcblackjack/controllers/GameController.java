package com.libertymutual.gfcblackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.gfcblackjack.models.Card;
import com.libertymutual.gfcblackjack.models.Game;

@Controller
@RequestMapping("/")
public class GameController {
	
	Game game;


	@GetMapping("")
	public String promptGameBegin() {
		return "index";
	}
	
	@PostMapping("/place-bet")
	public ModelAndView placeBet() {
		game = new Game();
		ModelAndView mv = new ModelAndView("place-bet");
		mv.addObject("money", game.player.money);
		return mv;
	}
	
	@PostMapping("/play")
	public ModelAndView playGame() {
		ModelAndView mv = new ModelAndView("/play");
		game.dealCards(game.player, 2);
		game.dealCards(game.dealer, 2);
		mv.addObject("playerCards", game.player.hand.cards);
		mv.addObject("dealerCards", game.dealer.hand.cards);
		mv.addObject("playerValues", game.player.hand.cardValues[0]);
		mv.addObject("dealerValues", game.dealer.hand.cardValues[0]);
		
		if (game.player.hand.hasAce) {
			mv.addObject("playerValuesOther", game.player.hand.cardValues[1]);
		}
		else if (game.dealer.hand.hasAce ) {
			mv.addObject("dealerValuesOther", game.dealer.hand.cardValues[1]);
		}

		
		return mv;
	}
	
	@GetMapping("/play")
	public String playMapping() {
		return"/play";
	}
	
	
	@PostMapping("/hit")
	public ModelAndView hit() {
		ModelAndView mv = new ModelAndView("play");
		game.dealCards(game.player, 1);
		mv.addObject("playerCards", game.player.hand.cards);
		mv.addObject("dealerCards", game.dealer.hand.cards);
		mv.addObject("playerValues", game.player.hand.cardValues[0]);
		mv.addObject("dealerValues", game.dealer.hand.cardValues[0]);
		
		if (game.player.hand.hasAce) {
			mv.addObject("playerValuesOther", game.player.hand.cardValues[1]);
		}
		else if (game.dealer.hand.hasAce ) {
			mv.addObject("dealerValuesOther", game.dealer.hand.cardValues[1]);
		}
		return mv;
	}
	
	@PostMapping("/stand")
	public String stand() {
		return "";
	}
	
	
}
