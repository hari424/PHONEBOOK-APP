package com.ashokit.service;

import java.util.List;
import com.ashokit.entity.Contact;

public interface ContactSerices {
	public boolean save(Contact contact);

	public List<Contact> getAllContacts();

	public Contact getContactById(Integer contactId);

	public boolean deleteById(Integer contactId);
}
