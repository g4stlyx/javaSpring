package com.spring.spring_intro.examples.a5;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

/*

 Context and Dependency Injection = CDI
 
 Important Annotatations:
 	@Inject (= @Autowired)
 	@Named (= @Component)
 	@Qualifier
 	@Scope
 	@Singleton
 
 
*/


//@Component
@Named
class BussinessService{
	private DataService dataService;
	
	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("setter injection");
		this.dataService = dataService;
	}
		
	public DataService getDataService() {
		return dataService;
	}
	
	
}

//@Component
@Named
class DataService{
	
}

@Configuration
@ComponentScan
public class App08JakartaContextsAndDepInj {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App08JakartaContextsAndDepInj.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
			System.out.println(context.getBean(BussinessService.class).getDataService());
			
		}
	}
	
}
