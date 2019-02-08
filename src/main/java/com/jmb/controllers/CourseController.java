package com.jmb.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.jmb.entity.Course;
import com.jmb.model.CourseModel;
import com.jmb.services.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	
	private static final String COURSES_VIEW = "list";
	private static final String COURSES_DETALLE = "coursodetalle";

	
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	
	/* LISTAR TODOS LOS CURSOS */
	@RequestMapping("/list")
	public ModelAndView getAllCourses() {
		
		LOG.info("ENTRA getAllCourses()");
		
		ModelAndView mod = new ModelAndView(COURSES_VIEW);
		
		 mod.addObject("courses", courseService.ListAllCourses());
		 
		 //TODO OJO HACE FALTA PARA AÑDAIR EN AL FORM ADD
		 mod.addObject("course", new CourseModel());
		
		return mod;
	}
	
	
	
	/*ADD NUEVO CURSO *"PARAMS CURSO  */
	@PostMapping("/add")
	public String addCourse(@ModelAttribute("course") CourseModel course) {
		
		LOG.info("ENTRA addCourse()  -- PARAM" + course.toString());
		
		courseService.addCourse(course);
		
		return "redirect:/courses/list";
	}
	
	
	
	/*DETALLE PARMS: ID*/
//	@GetMapping("/detalle")
	@RequestMapping("/detalle")
	public ModelAndView detalleCourse(int id) {
		
		
		ModelAndView mod = new ModelAndView(COURSES_DETALLE);
//		mod.addObject("id_curso", id);
		
		return mod;
//				"redirect:/courses/detalle";
	}
	
	
	
	
}
