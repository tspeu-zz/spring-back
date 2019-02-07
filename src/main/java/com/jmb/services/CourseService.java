package com.jmb.services;

import java.util.List;

import com.jmb.entity.Course;
import com.jmb.model.CourseModel;

public interface CourseService {

	public abstract List<CourseModel>ListAllCourses();
	
	//TODO
	public abstract Course detalleCourse(int id);
	
	
	//TODO 
	public abstract Course addCourse(CourseModel model);
	
	
	
	public abstract int deleteCourse(int id);
	
	public abstract Course updateCourse(Course course);
	
}
