package com.spring.spring_intro.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.spring.spring_intro.examples.a1") //= "@ComponentScan" since it is the default package
public class App00SimpleSpringContextAppLauncher {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App00SimpleSpringContextAppLauncher.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
	
}
