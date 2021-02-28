package com.ashokit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashokit.entity.Contact;
import com.ashokit.service.ContactSerices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = ContactController.class)
public class ContactControllerTest {
	@MockBean
	private ContactSerices serices;
	@Autowired
	private MockMvc mockMvc;

	public void test_savecontact() throws Exception {
		when(serices.save(Mockito.any())).thenReturn(true);
		Contact c=new Contact(101, "hari", "hari@gmail.com",(long) 555555555);
		ObjectMapper mapper=new ObjectMapper();
		String json=null;
		try {
			 json=mapper.writeValueAsString(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MockHttpServletRequestBuilder mvcRequestBuilders=MockMvcRequestBuilders.post("/").contentType("application/jsan")
																																					.content(json);
		MvcResult mvcResult = mockMvc.perform(mvcRequestBuilders).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(201, status);
	}
}
