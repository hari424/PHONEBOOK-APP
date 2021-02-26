package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashokit.entity.Contact;
import com.ashokit.exception.NoDataFoundException;
import com.ashokit.repository.ContactRepositry;

@Service
public class ContactSericesImpl implements ContactSerices {
	private ContactRepositry contactrepo;

	public ContactSericesImpl(ContactRepositry contactrepo) {
		this.contactrepo = contactrepo;
	}

	@Override
	public boolean save(Contact contact) {
		Contact saveContact = contactrepo.save(contact);
		return saveContact.getContactid() != null;
	}

	@Override
	public List<Contact> getAllContacts() {

		return contactrepo.findAll();
	}

	
	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactrepo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteById(Integer contactId) {
		try {
			contactrepo.deleteById(contactId);
			return true;
		} catch (Exception e) {
			throw new NoDataFoundException("NO RECORD FOUND TO DELETE");
		}

	}

}
