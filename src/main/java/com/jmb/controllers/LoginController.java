package com.jmb.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmb.constant.ViewConstant;
import com.jmb.model.UserCredentials;

@Controller
//@RequestMapping("/")
public class LoginController {

//	private static final String LOGIN = "login"; 
//	private static final String CONTACTS = "contacts"; 
	
	private static final Log LOG = LogFactory.getLog(EjercicioController.class);

	@GetMapping("/")
	public String redirectLogin() {
		LOG.info("METHOD: redirectLogin() ");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLogion(Model model,
							@RequestParam(name="error", required=false) String error, 
							@RequestParam(name="logout", required=false) String logout) {
		
		
		LOG.info("METHOD showLogion() PARAMS: ERROR = "+ error + "-- LOGOUT= " + logout);
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("user", new UserCredentials());
		
		LOG.info("METHOD showLogion() RETURNING LOGIN VIEW" );
		return ViewConstant.LOGIN;
	}
	
	
	@PostMapping("/logincheck")
	public String checkLogin(@ModelAttribute(name="userCredentials") UserCredentials user) {
		
		LOG.info("METHOD checkLogin() --PARAMS: UserCredentials = " + user.toString() );
		
		if(user.getUsername().equals("user") && user.getPassword().equals("user")) {
			
			LOG.info("METHOD checkLogin() RETURNING contacts VIEW" );
			return  ViewConstant.CONTACTS;
			
		} else {
			
			
		}
		
		LOG.info("METHOD checkLogin() redirect:/login?error" );
		return "redirect:/login?error";
	}
	
}
