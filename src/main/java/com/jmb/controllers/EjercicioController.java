package com.jmb.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.jmb.services.EjercicioService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {
	
	private static final Log LOGGER = LogFactory.getLog(EjercicioController.class);
	
	public static final String MENSAJE = "mensaje";
	public static final String EJERCICIO_VIEW = "ejercicio";
	public static final String EJERCICIO_RESULT = "ejerciciomensaje";
	

	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService;
	
	
	@GetMapping("/")
	public RedirectView redirect() {
		
		return new RedirectView("/ejercicio/uno");
	}
	
	
	
	@GetMapping("/uno")
	public ModelAndView metodo_UNO(String mens) {
		
//		metodo_DOS();
			
		LOGGER.info("ENTRA metodo_UNO MENSAJE" + mens);
		
		ModelAndView mod = new ModelAndView();
		
		 ejercicioService.setMensaje(mens);
		
		mod.addObject("mensaje", mens );

		mod.setViewName(EJERCICIO_VIEW);
		return mod;
//		
	}
	
	@PostMapping("/dos")
	public ModelAndView metodo_DOS( @ModelAttribute("mensaje") String mensaje) {
		
		ejercicioService.mostrarLog();
		
		LOGGER.info("ENTRA metodo_DOS MENSAJE" + mensaje);
		
		ModelAndView mod = new ModelAndView();
		
		
		mod.addObject("mensaje", mensaje);
			
		mod.setViewName(EJERCICIO_RESULT);
	
	
		
		return mod;
	}
	
	
	
	
}
