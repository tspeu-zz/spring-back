package com.jmb.converter;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jmb.entity.Course;
import com.jmb.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {

	// TRANFORMAR DE ENTITY A UN MODEL
	public CourseModel entityToModel(Course course) {

		CourseModel model = new CourseModel();

		model.setName(course.getName());
		model.setDescription(course.getDescription());
		model.setPrice(course.getPrice());
		model.setHours(course.getHours());

		return model;
	}
	
	
	/*CONVIERTE LA LISTA DE ENTITY A MODEL */
	public List<CourseModel> listEntityToModel(List<Course> courses) {
		
		List<CourseModel> listModel = new ArrayList<>();
		
		CourseModel model = new CourseModel();
		
			for (Course c : courses) {
				
				model = entityToModel(c);
				
				listModel.add(model);
				
			}
			
		
		return listModel;
	}

	// TRANFORMAR DE MODEL A ENTITY
	public Course modelToEntity(CourseModel model) {

		Course course = new Course();

		course.setName(model.getName());
		course.setDescription(model.getDescription());
		course.setHours(model.getHours());
		course.setPrice(model.getPrice());

		return course;
	}

}
