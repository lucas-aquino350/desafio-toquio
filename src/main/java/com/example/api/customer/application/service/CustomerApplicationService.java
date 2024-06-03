package com.example.api.customer.application.service;

import java.util.List;

import com.example.api.customer.application.api.*;
import com.example.api.customer.application.repository.CustomerRepository;
import com.example.api.customer.domain.Address;
import com.example.api.customer.domain.AddressType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public CustomerDetailedResponse findById(Long idCustomer) {
		log.info("[start] CustomerApplicationService - findById");
		log.info("[idCustomer] {}", idCustomer);
		Customer customer = customerRepository.findById(idCustomer);
		log.info("[finish] CustomerApplicationService - findById");
		return new CustomerDetailedResponse(customer);
	}

	public Page<CustomerDetailedResponse> findAll(Pageable pageable){
		log.info("[start] CustomerApplicationService - findAll");
		Page<Customer> pageCustomer = customerRepository.findAllByOrderByNameAsc(pageable);
		log.info("[finish] CustomerApplicationService - findAll");
		return pageCustomer.map(CustomerDetailedResponse::new);
	}

	@Override
	public void updateCustomer(Long idCustomer, CustomerUpdateRequest customerUpdateRequest) {
		log.info("[start] CustomerApplicationService - updateCustomer");
		Customer customer = customerRepository.findById(idCustomer);
		customer.updateCustomer(customerUpdateRequest);
		customerRepository.salva(customer);
		log.info("[finish] CustomerApplicationService - updateCustomer");
	}

    @Override
    public void deleteCustomer(Long idCustomer) {
		log.info("[start] CustomerApplicationService - deleteCustomer");
		log.info("[idCustomer] {}", idCustomer);
		Customer customer = customerRepository.findById(idCustomer);
		customerRepository.deleteCustomer(customer);
		log.info("[finish] CustomerApplicationService - deleteCustomer");
    }

	@Override
	public AddressResponse registerAddressCustomer(Long idCustomer, AddressRequest addressRequest) {
		log.info("[start] CustomerApplicationService - registerAddressCustomer");
		log.info("[idCustomer] {}", idCustomer);
		Customer customer = customerRepository.findById(idCustomer);
		Address address = new Address(addressRequest, customer);
		customer.addOrUpdateAddress(address);
		customerRepository.salva(customer);
		log.info("[finish] CustomerApplicationService - registerAddressCustomer");
		return new AddressResponse(address);
	}

	@Override
	public List<AddressListResponse> findAddressesByIdCustomer(Long idCustomer) {
		log.info("[start] CustomerApplicationService - findAddressesByIdCustomer");
		log.info("[idCustomer] {}", idCustomer);
		Customer customer = customerRepository.findById(idCustomer);
		List<Address> listAddress = customer.getAddresses();
		log.info("[finish] CustomerApplicationService - findAddressesByIdCustomer");
		return AddressListResponse.converteList(listAddress);
	}

	@Override
	public void deleteAddressCustomer(Long idCustomer, Long idAddress) {
		log.info("[start] CustomerApplicationService - deleteAddressCustomer");
		Customer customer = customerRepository.findById(idCustomer);
		customer.removeAddress(idAddress);
		customerRepository.salva(customer);
		log.info("[finish] CustomerApplicationService - deleteAddressCustomer");
	}
}