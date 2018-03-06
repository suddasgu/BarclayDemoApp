package com.barclay.demo.model;

import io.swagger.annotations.ApiModelProperty;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CUSTOMER")
public class Customer {
	
	@Id
	@ApiModelProperty(value="Auto generated ID")
	private String customerId;
	
	@ApiModelProperty(required=true)
	@NotBlank(message = "Mandatory:Customer First Name")
	private String firstName;
	
	@ApiModelProperty(required=true)
	@NotBlank(message = "Mandatory:Customer Last Name")
	private String lastName;
	
	@ApiModelProperty(required=true)
	@NotBlank(message = "Mandatory:Customer Address")
	private String address;

}
