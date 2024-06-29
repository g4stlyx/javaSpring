package com.g4stly.springboot.webApp1.loginAuthenticationService;

import org.springframework.stereotype.Service;

// used before the spring security was implemented, does nothing now
@Service
public class AuthenticationService {
	public boolean authenticate(String username,String password) {
		boolean isValidUsername = username.equalsIgnoreCase("g4stly");
		boolean isValidPassword = password.equalsIgnoreCase("password");
		System.out.println("name:"+ username);
		System.out.println("pwd:"+ password);
		return (isValidUsername && isValidPassword);
	}
}
