package com.jmb.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

//import com.jmb.controllers.ExmpleController;
import com.jmb.model.Person;
import com.jmb.services.ExampleService;

@Service("ejemploService")
public class ExampleServiceImpl implements ExampleService{

	
	private static final Log LOOGER = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPerson() {
		
		LOOGER.info("ENTRA SERVICIO getListPerson");
		
		List<Person> people = new ArrayList<>();
		
		people.add(new Person("Ozzy Osbourne", 65));
		people.add(new Person("James Heatfild", 55));
		people.add(new Person("Izz Stradlin ", 54));
		people.add(new Person("Jimy Hendrix", 89));


		return people;
		
	}

}
