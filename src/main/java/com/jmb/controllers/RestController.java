package com.jmb.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmb.component.JsonWrapper;
import com.jmb.converter.ContactConverter;
import com.jmb.model.ContactModel;
import com.jmb.repository.ContactRepository;
import com.jmb.services.JsonUtil;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	private static final Log LOG = LogFactory.getLog(RestController.class);
	
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	
	@Autowired
	private JsonUtil jsonUtil;
	
	//devuelve un un objeto
	@GetMapping("/checkrest")
	public ResponseEntity <JsonWrapper> checkRest(HttpServletRequest request) {
		
		String URL = request.getRequestURL().toString();
		
		JsonWrapper jsonWrapper = null;
		
		ContactModel model = contactConverter.convertEntityToModel(contactRepository.findById(1));
				
		jsonWrapper = jsonUtil.keepResult( URL, model, null);
		
		
		return new ResponseEntity<JsonWrapper>(jsonWrapper, HttpStatus.OK);
	}
	
	
	/**/
	@RequestMapping(value="/testget/{id}", method={RequestMethod.GET}, produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity <JsonWrapper> testGet(@PathVariable Integer id ){
		
		LOG.info("METHOD: testGet() PARAMS: " + id);;
		
		JsonWrapper jsonWrapper = null;
		
		ContactModel model = contactConverter.convertEntityToModel(contactRepository.findById(id));
		
		
		jsonWrapper = jsonUtil.keepResult("/testget{id}", model, null);
		
		return new ResponseEntity<JsonWrapper>(jsonWrapper, HttpStatus.OK);
	}
	
	
	/*******************************/
	//devuelve un un string
//	@GetMapping("/checkrest")
//	public ResponseEntity <String> checkRest() {
//		
//		
//		return new ResponseEntity<String>("OK FROM REST", HttpStatus.OK);
//	}
}
