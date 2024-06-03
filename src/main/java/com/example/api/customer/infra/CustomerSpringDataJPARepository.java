package com.example.api.customer.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.customer.domain.Customer;

public interface CustomerSpringDataJPARepository extends JpaRepository<Customer, Long> {

	List<Customer> findAllByOrderByNameAsc();

}
