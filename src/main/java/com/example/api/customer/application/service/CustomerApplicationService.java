package com.example.api.customer.application.service;

import java.util.List;
import java.util.Optional;

import com.example.api.customer.application.api.CustomerRequest;
import com.example.api.customer.application.api.CustomerResponse;
import com.example.api.customer.application.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import com.example.api.customer.domain.Customer;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerApplicationService implements CustomerService {

	private final CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAllByOrderByNameAsc();
	}

	public Optional<Object> findById(Long id) {
		return Optional.of(customerRepository.findById(id));
	}

	@Override
	public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
		log.info("[start] CustomerApplicationService - registerCustomer");
		log.info("[customerRequest] {}", customerRequest);
		Customer customer = customerRepository.salva(new Customer(customerRequest));
		log.info("[finish] CustomerApplicationService - registerCustomer");
		return new CustomerResponse(customer);
	}

}
