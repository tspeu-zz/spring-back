package com.jmb.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

// TODO: Auto-generated Javadoc
/**
 * The Class ContactController.
 */
//@PreAuthorize("permitAll()")
@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	/** The contact service. */
	@Autowired
	@Qualifier("contactService")
	private ContactService contactService;
	
	
	/**
	 * Show all.
	 *
	 * @return the string
	 */
	@GetMapping("/")
	public String showAll() {
		
		return "redirect:/contacts/showcontacts";
	}
	
	
	
	/**
	 * Candel.
	 *
	 * @return the string
	 */
	@GetMapping("/cancel")
	public String candel() {
		
		return "redirect:/contacts/showcontacts";
	}
	
/**
 * Edits the contact.
 *
 * @param id the id
 * @param modelParmams the model parmams
 * @return the string
 */
//	@PreAuthorize("hasRole('ROLE_USER')")
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
	
	
	/**
	 * Adds the contact.
	 *
	 * @param model the model
	 * @param modelParmams the model parmams
	 * @return the string
	 */
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
	
	
	
	/**
	 * Show contacts.
	 *
	 * @return the model and view
	 */
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		
		ModelAndView mod = new ModelAndView(ViewConstant.CONTACTS);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		mod.addObject("username", user.getUsername());
		//objeto que se envia a la vista
		mod.addObject("contacts", contactService.getAllListContacts());
		
		return mod;
		
	}
	
	/**
	 * Delete contact.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@GetMapping("/delete")
	public ModelAndView deleteContact(@RequestParam(name="id", required=true) int id) {
//		ModelAndView mod = new ModelAndView();
		
		LOG.info("METHOD: deleteContact() -- PARAMS" + id); 
		contactService.removeContact(id);
		return showContacts();
	}
	
	
	
}
