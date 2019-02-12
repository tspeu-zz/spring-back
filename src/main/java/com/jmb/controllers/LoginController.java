package com.jmb.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmb.constant.ViewConstant;

@Controller
//@RequestMapping("/")
public class LoginController {

//	private static final String LOGIN = "login"; 
//	private static final String CONTACTS = "contacts"; 

	private static final Log LOG = LogFactory.getLog(EjercicioController.class);

//	@GetMapping("/")
//	public String redirectLogin() {
//		LOG.info("METHOD: redirectLogin() ");
//		return "redirect:/login";
//	}

	@GetMapping("/login")
	public String showLogion(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		LOG.info("METHOD showLogion() PARAMS: ERROR = " + error + "-- LOGOUT= " + logout);

		model.addAttribute("error", error);
		model.addAttribute("logout", logout);

		LOG.info("METHOD showLogion() RETURNING LOGIN VIEW");
		return ViewConstant.LOGIN;
	}

	@GetMapping({ "/loginsuccess", "/" })
	public String checkLogin() {

		LOG.info("METHOD checkLogin() --PARAMS: UserCredentials = ");
		LOG.info("METHOD checkLogin() RETURNING contacts VIEW");

		return "redirect:/contacts/showcontacts";
	}

}
