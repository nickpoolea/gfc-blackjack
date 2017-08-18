package com.libertymutual.gfcblackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.gfcblackjack.models.Card;
import com.libertymutual.gfcblackjack.models.Game;
import com.libertymutual.gfcblackjack.models.Player;

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
		
//		for (Card c: game.player.hand.cards) {
//			System.out.println(c.getName());
//		}
		return mv;
	}
	
	@GetMapping("/play")
	public String playMapping() {
		return"/play";
	}
	
	
	@PostMapping("/hit")
	public ModelAndView hit() {
		ModelAndView mv = new ModelAndView("redirect:play");
		
		
		return mv;
	}
	
	@PostMapping("/stand")
	public String stand() {
		return "";
	}
	
	
}
