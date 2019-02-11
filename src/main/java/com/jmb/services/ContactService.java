package com.jmb.services;


import java.util.List;

import com.jmb.entity.ContactEntity;
import com.jmb.model.ContactModel;


public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel model);
	
	public abstract List<ContactModel> getAllListContacts();

	public abstract ContactEntity findById(int id);
	
	public abstract ContactModel findModelById(int id);
	
	public abstract void removeContact(int id);
}
