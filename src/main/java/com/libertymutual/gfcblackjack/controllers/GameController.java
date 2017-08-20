package com.libertymutual.gfcblackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.gfcblackjack.models.Game;

@Controller
@RequestMapping("/")
public class GameController {
	
	Game game;
	ModelAndView mvController;

	@GetMapping("")
	public String promptAndInitializeGame() {
		game = new Game();
		return "index";
	}
	
	@PostMapping("place-bet")
	public ModelAndView initializeGamePromptBegin() {
		mvController = new ModelAndView("place-bet");
		mvController.addObject("player", game.player);
		return mvController;
	}
	
	@GetMapping("place-bet")
	public ModelAndView placeBet() {
		mvController = game.getModelAndView();
		System.out.println(game.player.hand.cards.size());
		mvController.setViewName("place-bet");
		return mvController;
	}

	@PostMapping("/play")
	public ModelAndView playGame(int bet) {
		game.dealCards(game.player, 2, false);
		game.dealCards(game.dealer, 1, true);
		game.dealCards(game.dealer, 1, false);
		game.player.setBet(bet);
		return game.getModelAndView();
	}
	
	
	@PostMapping("/hit")
	public ModelAndView hit() {
		game.dealCards(game.player, 1, false);
		return game.getModelAndView();
	}
	
	@PostMapping("/stand")
	public ModelAndView stand() {
		game.autoDeal(game.dealer);
		game.player.setStood(true); 
		return game.getModelAndView();
	}
	
	@PostMapping("/reset")
	public String resetGame() {
		game.player.hand.clearHand();
		game.dealer.hand.clearHand();
		System.out.println(game.player.hand.cards.size());
		game.player.setStood(false);
		return "redirect:place-bet";
	}
		
}
