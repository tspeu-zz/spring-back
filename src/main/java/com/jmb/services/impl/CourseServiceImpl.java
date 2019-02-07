package com.jmb.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jmb.converter.CourseConverter;
import com.jmb.entity.Course;
import com.jmb.model.CourseModel;
import com.jmb.repository.CourseJpaRepository;
import com.jmb.services.CourseService;


@Service("courseService")
public class CourseServiceImpl  implements CourseService{
	
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseRepository;
	
	@Autowired
	private CourseConverter converter;
	

	@Override
	public List<CourseModel> ListAllCourses() {
		
		LOG.info("CourseService -- ListAllCourses()");
		
		//List<Course> listCourseEntity =  courseRepository.findAll(); 
		
		return  converter.listEntityToModel(courseRepository.findAll());
	}

	@Override
	public CourseModel detalleCourse(int id) {
		
		return converter.entityToModel(courseRepository.findById(id));
	}

	/*ADD */
	@Override
	public Course addCourse(CourseModel CourseModel) {
		
		LOG.info("CourseService -- addCourse()");
		
		//CONVIERTE A ENTITY EL MODEL DE LA VIEW
		return courseRepository.save(converter.modelToEntity(CourseModel));
	}

	
	
	@Override
	public int deleteCourse(int id) {
		courseRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		
		return courseRepository.save(course);
	}

}
