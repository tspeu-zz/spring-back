package com.jmb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		mod.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	///GENERA EL RESULTADO DE LA VISTA
	@PostMapping("/addPerson")
	public ModelAndView addPerson(@ModelAttribute("RESULT_VIEW") Person persona) {
		ModelAndView mod = new ModelAndView(RESULT_VIEW);
		mod.addObject("person", persona);
		return mod;
		
	}
	
}
