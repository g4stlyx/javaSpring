package com.spring.spring_intro.examples.a9;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 
	 @Component: generic for any class
	 use these instead of component, for a clearer code
	 	@Service: for class having business logic
	 	@Controller: used mostly in REST APIs for web controllers
	 	@Repository: classes which are saving/retrieving/manipulating data

	in28minutes Spring kursu bölüm 4 video 54 önemli tekrar bak

*/

@Configuration
@ComponentScan
public class App09SpringAnnotations {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App09SpringAnnotations.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
	
}
