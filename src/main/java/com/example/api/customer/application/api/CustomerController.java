package com.example.api.customer.application.api;

import java.util.List;
import com.example.api.customer.application.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
	public CustomerDetailedResponse findById(Long idCustomer) {
		log.info("[start] CustomerController - findById");
		CustomerDetailedResponse customer = customerService.findById(idCustomer);
		log.info("[finish] CustomerController - findById");
		return customer;
	}

	@Override
	public List<CustomerDetailedResponse> findAll() {
		log.info("[start] CustomerController - findAll");
		List<CustomerDetailedResponse> listCustomer = customerService.findAll();
		log.info("[finish] CustomerController - findAll");
		return listCustomer;
	}

	@Override
	public void updateCustomer(Long idCustomer, CustomerUpdateRequest customerUpdateRequest) {
		log.info("[start] CustomerController - updateCustomer");
		customerService.updateCustomer(idCustomer, customerUpdateRequest);
		log.info("[finish] CustomerController - updateCustomer");
	}

	@Override
	public void deleteCustomer(Long idCustomer) {
		log.info("[start] CustomerController - deleteCustomer");
		customerService.deleteCustomer(idCustomer);
		log.info("[finish] CustomerController - deleteCustomer");
	}

	@Override
	public AddressResponse registerAddressCustomer(Long idCustomer, AddressRequest addressRequest) {
		log.info("[start] CustomerController - registerAddressCustomer");
		AddressResponse addressCreated = customerService.registerAddressCustomer(idCustomer, addressRequest);
		log.info("[finish] CustomerController - registerAddressCustomer");
		return addressCreated;
	}

	@Override
	public List<AddressListResponse> findAddressesByIdCustomer(Long idCustomer) {
		log.info("[start] CustomerController - findAddressesByIdCustomer");
		List<AddressListResponse> listAddress = customerService.findAddressesByIdCustomer(idCustomer);
		log.info("[finish] CustomerController - findAddressesByIdCustomer");
		return listAddress;
	}

	@Override
	public void deleteAddressCustomer(Long idCustomer, Long idAddress) {
		log.info("[start] CustomerController - deleteAddressCustomer");
		customerService.deleteAddressCustomer(idCustomer, idAddress);
		log.info("[finish] CustomerController - deleteAddressCustomer");
	}
}


