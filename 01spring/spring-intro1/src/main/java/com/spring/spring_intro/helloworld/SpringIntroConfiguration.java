package com.spring.spring_intro.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record = class but getters, setters, and toString is auto created. Released in JDK 16.
record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

@Configuration
public class SpringIntroConfiguration {
	
	@Bean // this method produces a bean to be managed by the Spring container
	public String name() {
		return "g4";
	}
	
	@Bean
	public int age() {
		return 22;
	}
	
	@Bean
	public Person person() {
		return new Person("Sefa",21, address());
	}
	
	@Bean(name = "myCustomBeanNameForAddress")
	public Address address() {
		return new Address("221B Baker Street","London");
	}
	
	@Bean // u can use beans inside of beans
	public Person person2MethodCall() {
		return new Person(name(),age(), address());
	}
	
	@Bean
	@Primary // if there are 1+ Person beans, this is called when "System.out.println(context.getBean(Person.class));"
	// if there is no primary Person bean among multiple Person beans, an error occurs while running the code above
	public Person person3Parameters(String name, int age, Address address) {
		return new Person(name,age,address);
	}
	
}
