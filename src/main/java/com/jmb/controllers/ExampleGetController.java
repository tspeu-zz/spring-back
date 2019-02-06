package com.jmb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example2")
public class ExampleGetController {

		private static final String EXAMPLE_2 = "example2";
	
		
		//(USANDO OBJETO REDIRECT
		@GetMapping("/")
		public RedirectView redirect() {
			
			return new RedirectView("/example2/uno");
		}
		
		
		//localhost:8080/example2/uno?nm=Pepe
		@GetMapping("/uno")
		public ModelAndView requestUno(@RequestParam(name="nm",required= false , defaultValue="NOMBRE") String name) {
			ModelAndView mod = new ModelAndView(EXAMPLE_2);
			mod.addObject("nm_in_model", name);
			return  mod;
		}
		
		//foma2
		//localhost:8080/example2/dos/Pepe
		@GetMapping("/dos/{nm}")
		public ModelAndView resquestDos(@PathVariable("nm") String nombre) {
			ModelAndView dos = new ModelAndView(EXAMPLE_2);
			dos.addObject("nm_in_model", nombre );
			return dos;
			
		} 
}
