package com.example.api.customer.application.repository;

import com.example.api.customer.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAllByOrderByNameAsc();

    Object findById(Long id);

    Customer salva(Customer customer);
}
