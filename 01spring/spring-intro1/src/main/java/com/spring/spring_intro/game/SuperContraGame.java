package com.spring.spring_intro.game;

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
