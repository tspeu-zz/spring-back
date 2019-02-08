package com.jmb.repository;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.jmb.entity.Course;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.core.types.Predicate;
//import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLexampleRepo")
public class QueryDSLExampleRepo {

	
	//private QCourse qCourse = QCourse.course;
	
	//persistencia de la app
	@PersistenceContext
	private EntityManager em;
	
	//@Autowired
	//private JPAQuery<Course> query;
	
	/*
	//eje
	public void find(int id) {
		
		query.select(qCourse).from(qCourse).where(qCourse.id.eq(id)).fetchOne();
		
	}
	
	
	public List<Course> listaDeCursos() {
		
		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
		
		return courses;
	}
	
	
	public JPAQuery<Course> find(boolean exist) {
		
		BooleanBuilder bolBul = new BooleanBuilder(qCourse.name.startsWith("OP"));
		
		JPAQuery<Course> Query = new JPAQuery<Course>(em);
		
		if(exist) {
			Predicate uno = qCourse.name.endsWith("AR");
			
			
			bolBul.and(uno);
			
		} else {
			
			Predicate dos = qCourse.description.endsWith("OR");
			bolBul.and(dos);
		}
		
		
		
		return Query.select(qCourse).from(qCourse).where(bolBul);
		
	}
	
	
	*/
}
