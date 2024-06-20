package com.spring.spring_intro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.spring_intro.game.GameRunner;
import com.spring.spring_intro.game.GamingConsole;
import com.spring.spring_intro.game.PacmanGame;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
	

}
