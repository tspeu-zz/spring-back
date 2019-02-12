package com.jmb.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmb.constant.ViewConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
//@RequestMapping("/")
public class LoginController {

//	private static final String LOGIN = "login"; 
//	private static final String CONTACTS = "contacts"; 

	/** The Constant LOG. */
private static final Log LOG = LogFactory.getLog(EjercicioController.class);

//	@GetMapping("/")
//	public String redirectLogin() {
//		LOG.info("METHOD: redirectLogin() ");
//		return "redirect:/login";
//	}

	/**
 * Show logion.
 *
 * @param model the model
 * @param error the error
 * @param logout the logout
 * @return the string
 */
@GetMapping("/login")
	public String showLogion(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		LOG.info("METHOD showLogion() PARAMS: ERROR = " + error + "-- LOGOUT= " + logout);

		model.addAttribute("error", error);
		model.addAttribute("logout", logout);

		LOG.info("METHOD showLogion() RETURNING LOGIN VIEW");
		return ViewConstant.LOGIN;
	}

	/**
	 * Check login.
	 *
	 * @return the string
	 */
	@GetMapping({ "/loginsuccess", "/" })
	public String checkLogin() {

		LOG.info("METHOD checkLogin() --PARAMS: UserCredentials = ");
		LOG.info("METHOD checkLogin() RETURNING contacts VIEW");

		return "redirect:/contacts/showcontacts";
	}

}
