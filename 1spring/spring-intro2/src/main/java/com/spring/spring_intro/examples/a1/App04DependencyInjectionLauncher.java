package com.spring.spring_intro.examples.a1;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*

 DEPENDENCY INJECTION
 	1- Constructor-based inj
 	2- Setter-based inj
 	3- Field inj			: doesnt use setters or constructors, uses reflection
 	
 -------------------
 SOME TERMINOLOGY
 	Component: 		An instance of class to be managed by Spring
 	Dependency: 	variables/classes/interfaces NEEDED BY some other method/class etc.
 	ComponentScan: 	use this in the config class, scans packages
 	Dep. Inj:		identify beans, their dependencies, and wire them
 	IoC:			inversion of control
 	IoC Container:	To manage beans and dep.s: App.Context and BeanFactory
 	Autowiring: 	@Autowired
 -------------------
 	
 	
 
*/

@Component
class YourBussinessClass{
	// field injection
	//@Autowired
	Dependency1 dependency1;
	//@Autowired
	Dependency2 dependency2;
	
	// setters-based injection
	//@Autowired
	//public void setDependency1(Dependency1 dep1) {
	//	dependency1 = dep1;
	//}
	//@Autowired
	//public void setDependency2(Dependency2 dep2) {
	//	dependency2 = dep2;
	//}
	
	//constructors-based injection - this is recommended
	@Autowired
	public YourBussinessClass(Dependency1 dep1, Dependency2 dep2) {
		super();
		dependency1 = dep1;
		dependency2 = dep2;
	}
	
	
	public String toString() {
		return "Using "+ dependency1 + " and "+ dependency2;
	}
	
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration
@ComponentScan //= @ComponentScan("com.spring.spring_intro.examples.a1")
public class App04DependencyInjectionLauncher {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App04DependencyInjectionLauncher.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
			System.out.println(context.getBean(YourBussinessClass.class));
		
		}
	}
	
}
