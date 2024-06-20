package com.spring.spring_intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.spring.spring_intro.game.GameRunner;
import com.spring.spring_intro.game.GamingConsole;

/*
 	
	qualifier varsa qualifier aktif oluyor, yoksa primary
	bu ikisi de yoksa ama birden fazla aday varsa hata verir
	bir aday varsa zaten o çalışır
	
	qualifier spesifik bir adayı ismiyle çağırmak için kullanılıyor, 
	daha zahmetli ve karışık, birden fazla aday öncelikliyse kullan
 
 	primary dümdüz, tek aday öncelikliyse @ ver ilk o çalışır
 	
*/


@Configuration
@ComponentScan("com.spring.spring_intro.game")
public class App03GamingSpringBeans {
	
	public static void main(String[] args) {	
		try(var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)){	
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}






}