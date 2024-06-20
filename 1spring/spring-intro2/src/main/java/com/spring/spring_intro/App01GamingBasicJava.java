/*
  
coupling: how much work is involved in changing something

tightly coupled code: hard coded for a specific class, requires too much work with change
vs 
loosely coupled code: we want this as much as possible for obvious reasons
--------------------------

since gameRunner needs a game to run, game is a DEPENDENCY of GameRunner
when we use it like new GameRunner(game), we INJECT the DEPENDENCY there

*/

package com.spring.spring_intro;

import com.spring.spring_intro.game.GameRunner;
import com.spring.spring_intro.game.MarioGame;
import com.spring.spring_intro.game.PacmanGame;
import com.spring.spring_intro.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
		var marioGame = new MarioGame();
		var superContraGame = new SuperContraGame();
		var pacmanGame = new PacmanGame();
		var gameRunner = new GameRunner(marioGame);
		var gameRunner2 = new GameRunner(superContraGame);
		var gameRunner3 = new GameRunner(pacmanGame);
		gameRunner.run();
		gameRunner2.run();
		gameRunner3.run();
	}

}
