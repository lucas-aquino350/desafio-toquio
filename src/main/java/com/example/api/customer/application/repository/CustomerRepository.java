package com.example.api.customer.application.repository;

import com.example.api.customer.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerRepository {
    Customer salva(Customer customer);

    Customer findById(Long idCustomer);

    Page<Customer> findAllByOrderByNameAsc(Pageable pageable);

    void deleteCustomer(Customer customer);

}
