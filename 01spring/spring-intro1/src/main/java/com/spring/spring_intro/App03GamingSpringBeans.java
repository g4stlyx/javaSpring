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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.spring_intro.game.GameRunner;
import com.spring.spring_intro.game.GamingConsole;
import com.spring.spring_intro.game.MarioGame;
import com.spring.spring_intro.game.PacmanGame;
import com.spring.spring_intro.game.SuperContraGame;

public class App03GamingSpringBeans {
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
		
		
		
		
	}
}