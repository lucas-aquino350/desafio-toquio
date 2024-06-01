package com.example.api.customer.application.service;

import java.util.List;
import java.util.Optional;

import com.example.api.customer.application.api.CustomerRequest;
import com.example.api.customer.application.api.CustomerResponse;
import com.example.api.customer.application.api.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.customer.domain.Customer;
import com.example.api.customer.application.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerApplicationService implements CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerApplicationService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Object> findById(Long id) {
		return Optional.of(repository.findById(id));
	}

	@Override
	public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
		log.info("[start] CustomerApplicationService - registerCustomer");
		log.info("[finish] CustomerApplicationService - registerCustomer");
		return null;
	}

}
