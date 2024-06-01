package com.example.api.customer.application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.api.customer.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findAllByOrderByNameAsc();

}
