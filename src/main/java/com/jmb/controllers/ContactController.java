package com.jmb.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jmb.constant.ViewConstant;
//import com.jmb.entity.ContactEntity;
import com.jmb.model.ContactModel;
import com.jmb.services.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactService")
	private ContactService contactService;
	
	
	@GetMapping("/contacts")
	public String showAll() {
		
		return "redirect:/contacts/showcontacts";
	}
	
	
	
	@GetMapping("/cancel")
	public String candel() {
		
		return "redirect:/contacts/showcontacts";
	}
	
//	@PreAuthorize("hasRole('ROLE_USER')")
	@PreAuthorize("permitAll()")
	@GetMapping("/contactform")
	private String editContact(@RequestParam(name="id", required=false) int id, 
			Model modelParmams) {
		
		ContactModel contactModel = new ContactModel();
		
		LOG.info("METHOD: editContact() -- PARAMS-:  " +  id); 
		
		
		
		if(id  != 0 ) {
			LOG.info("METHOD: editContact() DEBE SER EDIT -- PARAMS-:  " +  id); 
			contactModel = contactService.findModelById(id);
			LOG.info("METHOD: editContact() -- contactModel : " + contactModel.toString()); 
			
			
		}
		else {
			
			LOG.info("METHOD: editContact() DEBE SER ALTA -- PARAMS-:  " +  id); 
		}
		
			
			modelParmams.addAttribute("contact", contactModel);
		
		
		
		return ViewConstant.CONTACT_FORM;
	}
	
	
	@PostMapping("/addcontact") 			//el atirbuto de la vista th:object="${contact}"
	private String addContact(@ModelAttribute(name ="contact") ContactModel model,
			Model modelParmams) {
		
		LOG.info("METHOD: addContact() -- PARAMS : " + model.toString()); 
	
			if( contactService.addContact(model) != null   ) {		
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
	
	@GetMapping("/delete")
	public ModelAndView deleteContact(@RequestParam(name="id", required=true) int id) {
//		ModelAndView mod = new ModelAndView();
		
		LOG.info("METHOD: deleteContact() -- PARAMS" + id); 
		contactService.removeContact(id);
		return showContacts();
	}
	
	
	
}
