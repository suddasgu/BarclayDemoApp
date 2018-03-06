package com.barclay.demo.config.controller;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import com.barclay.demo.config.TestContext;
import com.barclay.demo.controller.BarclayDemoController;
import com.barclay.demo.model.Customer;
import com.barclay.demo.service.BarclayDemoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class})
public class BarclayDemoControllerTest <T extends Customer>{

	@InjectMocks
	private BarclayDemoController<Customer> controller;
	@Mock
	private BarclayDemoService<Customer>  service;

	private PodamFactory podam;
	private MockMvc mockMvc;


	@Before
	public void setUp() throws Exception {
		podam = new PodamFactoryImpl();
		mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}


	@SuppressWarnings("unchecked")
	@Test
	public void addCustomerTest() throws Exception {
		final Customer customer = 
				podam.manufacturePojo(Customer.class);
		when(service.insertCustomer(customer)).thenReturn(new ResponseEntity<Customer>(customer,HttpStatus.OK));

		this.mockMvc.perform(post("/barclaydemoapi/add").content(converToJson(customer))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk());
	}


	public static String converToJson(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JodaModule());
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

}
