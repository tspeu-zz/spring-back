package com.jmb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jmb.model.UserCredentials;

@Controller
public class LoginController {

	private static final String LOGIN = "login"; 
	private static final String CONTACTS = "contacts"; 
	
	@GetMapping("/")
	public String redirectLogin() {
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLogion() {
		return LOGIN;
	}
	
	
	@PostMapping
	public String checkLogin(@ModelAttribute(name="UserCredentials") UserCredentials user) {
		
		if(user.getUsername().equals("user") && user.getPassword().equals("user")) {
			
			return CONTACTS;
			
		} else {
			
			
		}
		
		return "redirect:/"+LOGIN +"?error";
	}
	
}
