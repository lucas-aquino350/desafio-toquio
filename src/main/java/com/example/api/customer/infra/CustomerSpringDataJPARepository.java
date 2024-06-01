package com.example.api.customer.infra;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.api.customer.domain.Customer;

public interface CustomerSpringDataJPARepository extends CrudRepository<Customer, Long> {

	List<Customer> findAllByOrderByNameAsc();

}
