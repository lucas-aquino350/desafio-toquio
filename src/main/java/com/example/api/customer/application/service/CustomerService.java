package com.example.api.customer.application.service;

import com.example.api.customer.application.api.*;
import com.example.api.customer.domain.Customer;
import java.util.List;

public interface CustomerService {
    CustomerResponse registerCustomer(CustomerRequest customerRequest);

    Customer findById(Long idCustomer);

    List<Customer> findAll();

    void updateCustomer(Long idCustomer, CustomerUpdateRequest customerUpdateRequest);

    void deleteCustomer(Long idCustomer);

    AddressResponse registerAddressCustomer(Long idCustomer, AddressRequest addressRequest);
}
