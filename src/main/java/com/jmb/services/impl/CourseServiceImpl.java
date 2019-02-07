package com.jmb.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jmb.controllers.CourseController;
import com.jmb.entity.Course;
import com.jmb.repository.CourseJpaRepository;
import com.jmb.services.CourseService;


@Service("courseService")
public class CourseServiceImpl  implements CourseService{
	
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseRepository;
	
	

	@Override
	public List<Course> ListAllCourses() {
		
		LOG.info("CourseService -- ListAllCourses()");
		
		return courseRepository.findAll();
	}

	@Override
	public Course detalleCourse(int id) {
		
		return courseRepository.findOne(id);
	}

	@Override
	public Course addCourse(Course course) {
		
		LOG.info("CourseService -- addCourse()");
		
		return courseRepository.save(course);
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
