package com.jmb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jmb.model.UserCredentials;

@Controller
//@RequestMapping("/")
public class LoginController {

	private static final String LOGIN = "login"; 
	private static final String CONTACTS = "contacts"; 
//	
	@GetMapping("/")
	public String redirectLogin() {
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLogion(Model model,@RequestParam(name="error", required=false) String error, 
										@RequestParam(name="logout", required=false) String logout) {
		
		//ModelAndView mod = new ModelAndView(LOGIN);
		//mod.addObject("userCredentials", new UserCredentials());
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("user", new UserCredentials());
		
		
		return "login";
	}
	
	
	@PostMapping("/logincheck")
	public String checkLogin(@ModelAttribute(name="userCredentials") UserCredentials user) {
		
		if(user.getUsername().equals("user") && user.getPassword().equals("user")) {
			
			return  "contacts";
			
		} else {
			
			
		}
		
		return "redirect:/login?error";
	}
	
}
