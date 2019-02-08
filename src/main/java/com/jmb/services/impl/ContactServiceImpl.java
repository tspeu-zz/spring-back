package com.jmb.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jmb.converter.ContactConverter;
import com.jmb.entity.ContactEntity;
import com.jmb.model.ContactModel;
import com.jmb.repository.ContactRepository;
import com.jmb.services.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel model) {
		
		 ContactEntity entity = contactRepository.save(contactConverter.convertModelToEntity(model));
		 
		 
		return contactConverter.convertEntityToModel(entity);
	}

	@Override
	public List<ContactModel> getAllListContacts() {
		
		List<ContactEntity> contacts = contactRepository.findAll();
		List<ContactModel>  contactModel = new ArrayList<ContactModel>();
		
		for(ContactEntity e : contacts) {
			
			contactModel.add(contactConverter.convertEntityToModel(e));
			
		}
		
		return contactModel;
	}

}
