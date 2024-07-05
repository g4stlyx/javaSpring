package com.g4stly.springboot.restApi.intro;

public class HelloWorldBean {
	private String message;
	
	public HelloWorldBean(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String msg) {
		message = msg;
	}
	
	public String toString() {
		return "HelloWorldBean[message: ="+" message" + "]";
	}
	
	
}
