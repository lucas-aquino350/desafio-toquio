package com.example.api.customer.application.api;

import java.util.List;

import com.example.api.customer.application.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.customer.domain.Customer;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CustomerController implements CustomerApi {

	private final CustomerService customerService;

	@GetMapping
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return (Customer) customerService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	@Override
	public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
		log.info("[start] CustomerController - registerCustomer");
		CustomerResponse customerCreated = customerService.registerCustomer(customerRequest);
		log.info("[finish] CustomerController - registerCustomer");
		return customerCreated;
	}
}
