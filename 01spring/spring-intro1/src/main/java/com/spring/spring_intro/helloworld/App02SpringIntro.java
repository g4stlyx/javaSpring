/*

Spring container/Spring context/IOC Container: manages spring beans and their life cycle
	1- Bean Factory: Basic Spring Container
	2- Application Context: Advanced container with enterprise-specific features: (mostly used)
		easy for web, internationalization, and integration with Spring AOP

-------------------

Java Bean(EJB)             : classes with public default constructor, getters & setters, and serializable
POJO(Plain Old Java Object): any java object is POJO
Spring Bean                : any java object managed by Spring


 
*/

package com.spring.spring_intro.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02SpringIntro {

	public static void main(String[] args) {
		//1- Launch a Spring Context -	
		try(var context = new AnnotationConfigApplicationContext(SpringIntroConfiguration.class)){
			//2- Configure the things that we want Spring to manage
			//SpringIntoConfiguration - @Configuration
			// name - @Bean
			
			//3- Retrieve Beans managed by Spring
			System.out.println(context.getBean("name"));		
			System.out.println(context.getBean("age"));	
			System.out.println(context.getBean("person"));	
			System.out.println(context.getBean("myCustomBeanNameForAddress"));
			System.out.println(context.getBean(Address.class));	
			
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));

			
			// getting a list of all beans
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
		
		
		

	}
}
