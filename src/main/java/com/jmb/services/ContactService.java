package com.jmb.services;


import java.util.List;

import com.jmb.model.ContactModel;


public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel model);
	
	public abstract List<ContactModel> getAllListContacts();

}
