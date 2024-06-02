package com.example.api.customer.application.service;

import java.util.List;
import com.example.api.customer.application.api.CustomerRequest;
import com.example.api.customer.application.api.CustomerResponse;
import com.example.api.customer.application.api.CustomerUpdateRequest;
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

	@Override
	public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
		log.info("[start] CustomerApplicationService - registerCustomer");
		log.info("[customerRequest] {}", customerRequest);
		Customer customer = customerRepository.salva(new Customer(customerRequest));
		log.info("[finish] CustomerApplicationService - registerCustomer");
		return new CustomerResponse(customer);
	}

	@Override
	public Customer findById(Long id) {
		log.info("[start] CustomerApplicationService - findById");
		log.info("[idCustomer] {}", id);
		Customer customer = customerRepository.findById(id);
		log.info("[finish] CustomerApplicationService - findById");
		return customer;
	}

	public List<Customer> findAll(){
		log.info("[start] CustomerApplicationService - findAll");
		List<Customer> listCustomer = customerRepository.findAllByOrderByNameAsc();
		log.info("[finish] CustomerApplicationService - findAll");
		return listCustomer;
	}

	@Override
	public void updateCustomer(Long id, CustomerUpdateRequest customerUpdateRequest) {
		log.info("[start] CustomerApplicationService - updateCustomer");
		Customer customer = customerRepository.findById(id);
		customer.updateCustomer(customerUpdateRequest);
		customerRepository.salva(customer);
		log.info("[finish] CustomerApplicationService - updateCustomer");
	}
}