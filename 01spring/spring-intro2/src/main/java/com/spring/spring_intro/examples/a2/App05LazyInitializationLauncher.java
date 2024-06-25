package com.spring.spring_intro.examples.a2;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*

 Lazy Initialization vs Eager Initialization(default is eager)
 
 lazy is neither recommended nor frequently used, no need to even know
 
*/



@Component
class ClassA{
	
}

@Component
@Lazy
class ClassB{
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		System.out.println("Some initialization logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("do smth");
	}
}



@Configuration
@ComponentScan
public class App05LazyInitializationLauncher {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App05LazyInitializationLauncher.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
			context.getBean(ClassB.class).doSomething();
		}
	}
	
}
