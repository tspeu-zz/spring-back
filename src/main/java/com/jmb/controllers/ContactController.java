package com.jmb.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmb.constant.ViewConstant;
import com.jmb.model.ContactModel;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(EjercicioController.class);
	
	
	
	@GetMapping("/cancel")
	public String candel() {
		
		return ViewConstant.CONTACTS;
	}
	

	
	@GetMapping("/contactform")
	private String redirectContactDorm(Model model) {
		
		model.addAttribute("contact", new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}
	
	
	@PostMapping("/addcontact") 			//el atirbuto de la vista th:object="${contact}"
	private String addContact(@ModelAttribute(name ="contact") ContactModel model,
			Model modelParmams) {
		
		modelParmams.addAttribute("result", 1);
		
		LOG.info("METHOD: addContact() -- PARAMS" + model.toString()); 
		
		return ViewConstant.CONTACTS;
	}
	
	
	
}
