package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ashokit.service.ContactSerices;

@WebMvcTest(value = ContactController.class)
public class ContactControllerTest {
	@MockBean
	private ContactSerices serices;
	@Autowired
	private MockMvc mockMvc;

	public void test_savecontact() {

	}
}
