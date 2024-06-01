package com.example.api.customer.application.api;

import com.example.api.customer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();

    Optional<Object> findById(Long id);

    CustomerResponse registerCustomer(CustomerRequest customerRequest);
}
