package com.spring.spring_intro.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier") // when we want this to run specifically, we call it by that string
public class SuperContraGame implements GamingConsole {
	public SuperContraGame() {}

	@Override
	public void up() {
		System.out.println("Jump");
	}
	@Override
	public void down() {
		System.out.println("sit down");
	}
	@Override
	public void left() {
		System.out.println("Go back");
	}
	@Override
	public void right() {
		System.out.println("shoot");
	}
	
	
}
