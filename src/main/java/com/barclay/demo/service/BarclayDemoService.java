package com.barclay.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.barclay.demo.model.Customer;
import com.barclay.demo.repository.CustomerRepository;


@Service
public class BarclayDemoService<T extends Customer> {
	
	private Logger logger = LoggerFactory.getLogger(BarclayDemoService.class);
	
	private ResponseEntity<Customer> respEntity;
	
	@Autowired
    CustomerRepository repo;

	@SuppressWarnings("unchecked")
	public ResponseEntity<Customer> insertCustomer(Customer customer) {
	    Customer result= repo.save(customer);
		respEntity=new ResponseEntity<Customer>(result,HttpStatus.OK);
		return respEntity;
	}

}
