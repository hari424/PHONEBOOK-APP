package com.ashokit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Contact;
import com.ashokit.exception.NoDataFoundException;
import com.ashokit.service.ContactSerices;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
	Logger logger = LoggerFactory.getLogger(ContactController.class);
	private ContactSerices contactservices;

	public ContactController(ContactSerices contactservices) {
		this.contactservices = contactservices;
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Contact contact) {
		logger.debug("***     Save Contact() Excution Started     * **");
		try {
			boolean issave = contactservices.save(contact);
			if (issave) {
				logger.info("***     Save Contact Contact Saved     * **");
				return new ResponseEntity<>("contact save", HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("Exception occers Saved Contact ::" + e.getMessage());
		}
		logger.info("***     Save Contact() Contact Not Saved     ***");
		return new ResponseEntity<>("Failed to save", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping
	public ResponseEntity<List<Contact>> getAllcontacts() {
		logger.debug("***     getAll Contacts() Excution Started     * **");
		List<Contact> allContacts = null;
		try {
			allContacts = contactservices.getAllContacts();
			if (allContacts.isEmpty()) {
				logger.info("***     getAll Contacts()  Record Not Found     ***");
			}
		} catch (Exception e) {
			logger.error("Exception occers   GetAllContact  ::" + e.getMessage());
		}
		logger.debug("***     getAll Contacts() Excution Ended     * **");
		return new ResponseEntity<>(allContacts, HttpStatus.OK);
	}

	@GetMapping("/{contactId}")
	public ResponseEntity<Contact> getContactByid(@PathVariable Integer contactId) {
		logger.debug("***     getContactsById() Excution Started     * **");
		Contact contact = null;
		try {
			contact = contactservices.getContactById(contactId);
			if (contact == null) {
				throw new NoDataFoundException("NO CONTTACT FOUND");
			}
		} catch (Exception e) {
			logger.error("Exception occers Get Contact By Id::" + e.getMessage());
		}
		logger.debug("***     getContactsById() Excution Ended     * **");
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}

	@DeleteMapping("/{contactId}")
	public ResponseEntity<String> delContactByid(@PathVariable Integer contactId) {
		logger.debug("***     DeleteContactsById() Excution Startred     * **");
		ResponseEntity<String> responseEntity = null;
		try {
			boolean isDeleteById = contactservices.deleteById(contactId);
			if (isDeleteById)
				logger.info("***      DeleteContactsById()    Record Delete ***");
			responseEntity = new ResponseEntity<>("Delete", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occers DeleteContactsById   ::" + e.getMessage());
		}
		logger.debug("***     DeleteContactsById() Excution Ended     * **");
		responseEntity = new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}
}
