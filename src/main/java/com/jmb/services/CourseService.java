package com.jmb.services;

import java.util.List;

import com.jmb.entity.Course;

public interface CourseService {

	public abstract List<Course>ListAllCourses();
	
	public abstract Course detalleCourse(int id);
	
	public abstract Course addCourse(Course course);
	
	public abstract int deleteCourse(int id);
	
	public abstract Course updateCourse(Course course);
	
}
