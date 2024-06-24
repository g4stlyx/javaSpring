package com.g4stly.spring_boot.spring_boot_intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
  
 spring boot provides:
 	starter projects: 	auto decided dependencies for each field like (web, testing, security etc.)
 	auto configuration:	it is done as default and can be overwritten from "Maven Dependencies" folder
 	dev tools:			like some extensions for the server restart itself with every change in the code auto
 	
 	profiles: 	
 		different configurations for diff env.s(like dev env, prod. env, test env etc.)
 		or diff. web services need diff. configurations
 
 	configuration properties:
 		i think these are like env. variables
 		
 	embedded servers:
 		*Old way to deploy java apps: Install java, install web/app server(tomcat,websphere etc.), deploy the app WAR
 		*Now w/ embedded servers: install java, run JAR file
 		to run jar files: "java -jar jarFile.jar"
 
 	actuator:
 		for monitoring and managing the app in prod
 		shows:
 			beans, health, metrics, mappings
 		as default, go to localhost:8080/actuator to see info about things above
 
 	Spring vs Spring Boot vs Spring MVC:
 		important topic, take a look at it again.
 	
 
*/

@SpringBootApplication
public class SpringBootIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIntroApplication.class, args);
	}

}
