package com.jmb.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.jmb.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3 {
	
	public static final String FORM_VIEW = "formulario";
	public static final String RESULT_VIEW = "resultado";
	
	//LOG
	
	private static final Log LOGGER = LogFactory.getLog(Example3.class);

	/////////////////////////////////////////////////////////////////
	//REDIRECCIONAR CUANDO EL URL ES SOLO LA RAIZ
	//http://localhost:8080/example3/
	////////////////////////////////////////////
	/* 1 FORMA*/
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example3/showform";
//	}
	
	//(USANDO OBJETO REDIRECT
	@GetMapping("/")
	public RedirectView redirect() {
		
		return new RedirectView("/example3/showform");
	}
	
	//////////////////////////////////////////////////////////////////
	
	
	//ESTO GENERA LA VISTA DEL FORM
	@GetMapping("/showform")
	public String showForm(Model mod) {
		LOGGER.info("ALGO DE INFO" + mod.toString());
		LOGGER.warn("ALGO DE WARNING->");
		LOGGER.error("ERORES--->");
		LOGGER.debug("DEBUG--->");

		mod.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	///GENERA EL RESULTADO DE LA VISTA
	@PostMapping("/addPerson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person persona, BindingResult bindingResult) {
	
		LOGGER.info("addPerson  -- @PARAMS:" + persona.toString());
		
		ModelAndView mod = new ModelAndView();
		LOGGER.warn("------bindingResult getAllErrors->"  +  bindingResult.getAllErrors());
		LOGGER.warn("------bindingResult getObjectName->"  +  bindingResult.getObjectName());
		LOGGER.warn("------bindingResult toString->"  +  bindingResult.toString());
		
			if(bindingResult.hasErrors()) {
				
				LOGGER.info("addPerson  -- ERROR VALIDACION:" + persona.toString());
				mod.setViewName(FORM_VIEW);
				
			} else {
				
				mod.setViewName(RESULT_VIEW);
				mod.addObject("person", persona);
			}
		
		
		
		LOGGER.info("TEMPLATE: RESULT_VIEW  -- DATA:" + persona.toString());
		return mod;
		
	}
	
}
