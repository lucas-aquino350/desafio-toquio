package com.example.api.customer.domain;

import com.example.api.customer.application.api.CustomerRequest;
import com.example.api.customer.application.api.CustomerUpdateRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	@NotBlank
	private String name;

	@Column(nullable = false)
	@NotBlank
	@Email
	private String email;

	public Customer(CustomerRequest customerRequest) {
		this.name = customerRequest.getName();
		this.email = customerRequest.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void updateCustomer(CustomerUpdateRequest customerUpdateRequest) {
		updateName(customerUpdateRequest.getName());
		updateEmail(customerUpdateRequest.getEmail());
	}

	private void updateName(String name) {
		if (isValid(name)) {
			this.name = name;
		}
	}

	private void updateEmail(String email) {
		if (isValid(email)) {
			this.email = email;
		}
	}

	private boolean isValid(String value) {
		return value != null && !value.isEmpty();
	}

}
