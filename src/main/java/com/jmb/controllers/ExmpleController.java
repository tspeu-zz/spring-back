package com.jmb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExmpleController {

	public static final String EXAMPLE_VIEW = "example";
	
	
	/* 1rea forma de importar vistas desde el template localhost/example/exampleString
	 *             el metodo que atiende			tipo te peticion */
	//@RequestMapping(value="/exampleString", method= RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
	
		model.addAttribute("name", "Rambo =)");				
		return EXAMPLE_VIEW;
	}
	
	//2da forma devuelve un objeto ModelAndView localhost/example/exampleMAV
//	@RequestMapping(value="/exampleMAV", method= RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleModelAndView() {
		ModelAndView mod = new ModelAndView(EXAMPLE_VIEW);
		
		mod.addObject("name", "Predator II");
		
		return mod;
				//new ModelAndView(EXAMPLE_VIEW);
	}
	
	
}
