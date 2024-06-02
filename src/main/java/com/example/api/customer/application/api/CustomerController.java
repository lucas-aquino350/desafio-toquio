package com.example.api.customer.application.api;

import java.util.List;
import java.util.function.Consumer;

import com.example.api.customer.application.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.customer.domain.Customer;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CustomerController implements CustomerApi {

	private final CustomerService customerService;

	@Override
	public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
		log.info("[start] CustomerController - registerCustomer");
		CustomerResponse customerCreated = customerService.registerCustomer(customerRequest);
		log.info("[finish] CustomerController - registerCustomer");
		return customerCreated;
	}

	@Override
	public CustomerDetailedResponse findById(Long id) {
		log.info("[start] CustomerController - findById");
		Customer customer = customerService.findById(id);
		log.info("[finish] CustomerController - findById");
		return new CustomerDetailedResponse(customer);
	}

	@Override
	public List<CustomerDetailedResponse> findAll() {
		log.info("[start] CustomerController - findAll");
		List<Customer> listCustomer = customerService.findAll();
		log.info("[finish] CustomerController - findAll");
		return CustomerDetailedResponse.converte(listCustomer);
	}

	@Override
	public void updateCustomer(Long id, CustomerUpdateRequest customerUpdateRequest) {
		log.info("[start] CustomerController - updateCustomer");
		customerService.updateCustomer(id, customerUpdateRequest);
		log.info("[finish] CustomerController - updateCustomer");
	}

	@Override
	public void deleteCustomer(Long id) {
		log.info("[start] CustomerController - deleteCustomer");
		customerService.deleteCustomer(id);
		log.info("[finish] CustomerController - deleteCustomer");
	}
}
