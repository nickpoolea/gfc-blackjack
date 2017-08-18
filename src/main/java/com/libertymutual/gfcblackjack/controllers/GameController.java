package com.libertymutual.gfcblackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GameController {

	@GetMapping("")
	public String beginGame() {
		return "index";
	}
	
	@PostMapping("/game")
	public String playGame() {
		return "game";
	}
	
}
