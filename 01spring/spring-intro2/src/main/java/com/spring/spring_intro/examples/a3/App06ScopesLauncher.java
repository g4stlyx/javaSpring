package com.spring.spring_intro.examples.a3;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
 	boş teori gibi duruyor
 	

 Scopes are only for web-aware Spring ApplicationContext:
 	Singleton: one obj instance per Spring IoC container
 	Prototype: 1+ obj instances
 	
 	Request: 1 obj instance per single HTTP req
 	Session: 1 obj instance per user HTTP session
 	Application: 1 obj instance per web app runtime
 	WebSocket: 1 obj instance per WebSocket instance
 	
*/

@Configuration
@ComponentScan
public class App06ScopesLauncher {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App06ScopesLauncher.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);		
		}
	}
	
}
