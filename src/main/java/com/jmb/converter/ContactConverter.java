package com.jmb.converter;

import org.springframework.stereotype.Component;

import com.jmb.entity.ContactEntity;
import com.jmb.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	// convert model to entity
	public ContactEntity convertModelToEntity(ContactModel model) {

		ContactEntity entity = new ContactEntity();

		entity.setFirstname(model.getFirstname());
		entity.setLastname(model.getLastname());
		entity.setTelephone(model.getTelephone());
		entity.setCity(model.getCity());

		return entity;
	}

	// convert entity to model
	
	public ContactModel convertEntityToModel(ContactEntity entity) {
		
		ContactModel model = new ContactModel();
		
		model.setId(entity.getId());
		model.setFirstname(entity.getFirstname());
		model.setLastname(entity.getLastname());
		model.setTelephone(entity.getCity());
		model.setCity(entity.getCity());
		
		
		return model;
		
		
	}

}
