package com.jmb.controllers;

//import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jmb.component.EjemploComponent;
//import com.jmb.component.ReqTimeInterceptor;
//import com.jmb.model.Person;
import com.jmb.services.ExampleService;

@Controller
@RequestMapping("/example")
public class ExmpleController {

	public static final String EXAMPLE_VIEW = "example";
	
	private static final Log LOOGER = LogFactory.getLog(ExmpleController.class);
	
	
	//////////////////////////////importar componente
	@Autowired
	@Qualifier("ejemploComponent")
	private EjemploComponent exampleComponent;
	/////////////////////////////////////////////
	
	@Autowired
	@Qualifier("ejemploService")
	private   ExampleService exampleServiceT;
	
	
	//////////////////////////////////////////////////////
	/* 1rea forma de importar vistas desde el template localhost/example/exampleString
	 *             el metodo que atiende			tipo te peticion */
	//@RequestMapping(value="/exampleString", method= RequestMethod.GET)
	//////////////////////////////////////////////////////
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
	
		//usar componente
		exampleComponent.saluda();
		
		//model.addAttribute("persona", new Person("Rambo", 40));			
		model.addAttribute("persona", exampleServiceT.getListPerson());				

		return EXAMPLE_VIEW;
	}
	
	////////////////////////////////////////////////////////////
	//2da forma devuelve un objeto ModelAndView localhost/example/exampleMAV
	//	@RequestMapping(value="/exampleMAV", method= RequestMethod.GET)
	////////////////////////////////////////////////////////////->
	@GetMapping("/exampleMAV")
	public ModelAndView exampleModelAndView() {
		ModelAndView mod = new ModelAndView(EXAMPLE_VIEW);
		
//		mod.addObject("persona", new Person("Predator II", 4350));
		
		//LAMADA AL SERVICIO
		LOOGER.info("LLAMA AL SERVICO ExampleService");
		mod.addObject("persona", exampleServiceT.getListPerson());	
		
		return mod;
				//new ModelAndView(EXAMPLE_VIEW);
	}
	
	
//	private List<Person> getListaPersonas() {
//		
//		
//	}
	
}
