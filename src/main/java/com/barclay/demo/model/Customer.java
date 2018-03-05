package com.barclay.demo.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CUSTOMER")
public class Customer {
	private String customerId;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	private String address;

}
