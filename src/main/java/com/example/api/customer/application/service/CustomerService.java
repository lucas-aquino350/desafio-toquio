package com.example.api.customer.application.service;

import com.example.api.customer.application.api.CustomerRequest;
import com.example.api.customer.application.api.CustomerResponse;
import com.example.api.customer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();

    Optional<Object> findById(Long id);

    CustomerResponse registerCustomer(CustomerRequest customerRequest);
}
