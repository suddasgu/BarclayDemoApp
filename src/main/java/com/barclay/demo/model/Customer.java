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
	
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

}
