package com.spring.spring_intro.examples.a4;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/*
 		önemli, flutter'da karşılıkları: initState() ve dispose()

 PostConstruct: bean oluşturulduktan sonra bir kez çalışır(başlangıçta istenen bir şey varsa kullanılır)
 PreDestroy   : bean dispose edilmeden önce bir kez olmak üzere çalışır(db kapatmak için vs kullanılır.)
 ---------------
 
 jakarta
 	
*/



@Component
class SomeClass{
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDep) {
		super();
		someDependency = someDep;
		System.out.println("all dep.s are ready");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("things cleaned");
	}
}

@Component
class SomeDependency{
	public void getReady() {
		System.out.println("dep is getting ready");
	}
}



@Configuration
@ComponentScan
public class App07PostConstructAndPreDestroy {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App07PostConstructAndPreDestroy.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		}
	}
	
}
