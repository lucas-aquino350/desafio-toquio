package com.example.api.customer.application.service;

import com.example.api.customer.application.api.CustomerRequest;
import com.example.api.customer.application.api.CustomerResponse;
import com.example.api.customer.application.api.CustomerUpdateRequest;
import com.example.api.customer.domain.Customer;
import java.util.List;

public interface CustomerService {
    CustomerResponse registerCustomer(CustomerRequest customerRequest);

    Customer findById(Long id);

    List<Customer> findAll();

    void updateCustomer(Long id, CustomerUpdateRequest customerUpdateRequest);
}
