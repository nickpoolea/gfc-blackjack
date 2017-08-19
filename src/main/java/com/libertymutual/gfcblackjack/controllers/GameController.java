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
		game.dealCards(game.player, 2);
		game.dealCards(game.dealer, 2);
		ModelAndView mv = game.getModelAndView();
		return mv;
	}
	
	@GetMapping("/play") 
	public ModelAndView playGetMapping() {
		ModelAndView mv = game.getModelAndView();
		return mv;
	}
	
	
	@PostMapping("/hit")
	public ModelAndView hit() {
		game.dealCards(game.player, 1);
		ModelAndView mv = game.getModelAndView();
		return mv;
	}
	
	@PostMapping("/stand")
	public ModelAndView stand() {
		game.autoDealer();
		game.player.hasStood = true;
		ModelAndView mv = game.getModelAndView();
		return mv;
	}
	
	@PostMapping("/reset")
	public String resetGame() {
		game.player.hand.clearHand();
		game.dealer.hand.clearHand();
		game.player.hasStood = false;
		game.dealCards(game.player, 2);
		game.dealCards(game.dealer, 2);
		return "redirect:/play";
	}
	
	
}
