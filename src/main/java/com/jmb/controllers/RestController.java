package com.jmb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmb.converter.ContactConverter;
import com.jmb.model.ContactModel;
import com.jmb.repository.ContactRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	
	//devuelve un un objeto
	@GetMapping("/checkrest")
	public ResponseEntity <ContactModel> checkRest() {
		
		
		ContactModel model = contactConverter.convertEntityToModel(contactRepository.findById(1));
				
			
		return new ResponseEntity<ContactModel>(model, HttpStatus.OK);
	}
	
	
	
	//devuelve un un string
//	@GetMapping("/checkrest")
//	public ResponseEntity <String> checkRest() {
//		
//		
//		return new ResponseEntity<String>("OK FROM REST", HttpStatus.OK);
//	}
}
