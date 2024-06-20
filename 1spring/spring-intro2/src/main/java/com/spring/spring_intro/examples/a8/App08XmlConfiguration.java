package com.spring.spring_intro.examples.a8;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 
 there is literally no reason to learn or implement this
 if needed for some reason, just google it or ask gpt
 
*/


@Configuration
@ComponentScan
public class App08XmlConfiguration {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App08XmlConfiguration.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
	
}
