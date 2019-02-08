package com.jmb.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jmb.constant.ViewConstant;
import com.jmb.model.ContactModel;
import com.jmb.services.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(EjercicioController.class);
	
	@Autowired
	@Qualifier("contactService")
	private ContactService contactService;
	
	
	@GetMapping("/cancel")
	public String candel() {
		
		return "redirect:/contacts/showcontacts";
	}
	
	
	@GetMapping("/contactform")
	private String redirectContactDorm(Model model) {
		
		model.addAttribute("contact", new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}
	
	
	@PostMapping("/addcontact") 			//el atirbuto de la vista th:object="${contact}"
	private String addContact(@ModelAttribute(name ="contact") ContactModel model,
			Model modelParmams) {
		
		LOG.info("METHOD: addContact() -- PARAMS" + model.toString()); 
		
			if( contactService.addContact(model)  !=null ) {		
				modelParmams.addAttribute("result", 1);			
			} else {	
				modelParmams.addAttribute("result", 0);
			}
		
		return "redirect:/contacts/showcontacts";
	}
	
	
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		
		ModelAndView mod = new ModelAndView(ViewConstant.CONTACTS);
		
		//objeto que se envia a la vista
		mod.addObject("contacts", contactService.getAllListContacts());
		
		return mod;
		
	}
	
	
	
}
