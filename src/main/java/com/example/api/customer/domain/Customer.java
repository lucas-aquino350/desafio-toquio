package com.example.api.customer.domain;

import com.example.api.customer.application.api.CustomerRequest;
import com.example.api.customer.application.api.CustomerUpdateRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, unique = true, nullable = false)
	private Long idCustomer;

	@Column(nullable = false)
	@NotBlank
	private String name;

	@Column(nullable = false, unique = true)
	@NotBlank
	@Email
	private String email;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addresses;

	public Customer(CustomerRequest customerRequest) {
		this.name = customerRequest.getName();
		this.email = customerRequest.getEmail();
		this.addresses = new ArrayList<>();
	}

	public void addAddress(Address address){
		this.addresses.add(address);
	}

	public void removeAddress(Address address){
		this.addresses.remove(address);
	}

	public Optional<Address> getPrincipalAddress() {
		return addresses.stream()
				.filter(address -> address.getAddressType() == AddressType.PRINCIPAL)
				.findFirst();
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
