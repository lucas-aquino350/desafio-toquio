package com.example.api.customer.application.repository;

import com.example.api.customer.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer salva(Customer customer);

    Customer findById(Long id);

    List<Customer> findAllByOrderByNameAsc();

    void deleteCustomer(Customer customer);
}
