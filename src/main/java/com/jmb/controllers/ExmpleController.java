package com.jmb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jmb.model.Person;

@Controller
@RequestMapping("/example")
public class ExmpleController {

	public static final String EXAMPLE_VIEW = "example";
	
	
	/* 1rea forma de importar vistas desde el template localhost/example/exampleString
	 *             el metodo que atiende			tipo te peticion */
	//@RequestMapping(value="/exampleString", method= RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
	
		
//		model.addAttribute("persona", new Person("Rambo", 40));			
		model.addAttribute("persona", getListaPersonas());				

		return EXAMPLE_VIEW;
	}
	
	//2da forma devuelve un objeto ModelAndView localhost/example/exampleMAV
//	@RequestMapping(value="/exampleMAV", method= RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleModelAndView() {
		ModelAndView mod = new ModelAndView(EXAMPLE_VIEW);
		
//		mod.addObject("persona", new Person("Predator II", 4350));
		mod.addObject("persona", getListaPersonas());	
		
		return mod;
				//new ModelAndView(EXAMPLE_VIEW);
	}
	
	
	private List<Person> getListaPersonas() {
		
		List<Person> people = new ArrayList<>();
		
		people.add(new Person("Ozzy Osbourne", 65));
		people.add(new Person("James Heatfild", 55));
		people.add(new Person("Izz Stradlin ", 54));
		people.add(new Person("Jimy Hendrix", 89));


		return people;
		
	}
	
}
