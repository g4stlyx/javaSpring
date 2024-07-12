package com.g4stly.springboot.webApp1.login;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.g4stly.springboot.webApp1.loginAuthenticationService.AuthenticationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	//private Logger logger = LoggerFactory.getLogger(getClass());
	
	//was active before the spring security implementation
	//private AuthenticationService authenticationService = new AuthenticationService();

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	@GetMapping(path="/basic-auth")
	public String basicAuthCheck() {
		return "Success";
	}
	
	public static String getLoggedinUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
	
	//was active before the spring security implementation
	//@RequestMapping(value="login", method= RequestMethod.GET) //login.jsp
	 //use @RequestParam to get the parameter named "name" url/?name=g4
	 //use ModelMap to use that parameter in your jsp file
	//public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		//model.put("name", name); // registering the name parameter as "name"
		//return "login";
	//}	
	
	//was active before the spring security implementation
	//@RequestMapping(value="/", method= RequestMethod.POST)
	//public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
	//	if(authenticationService.authenticate(name, password)) {
	//		model.put("name", name);
	//		model.put("password", password);
	//		return "welcome";
	//	}
	//	model.put("errorMessage","Invalid Credentials");
	//	return "login";
	//}
	
}
