package com.example.api.customer.infra;

import com.example.api.customer.application.repository.CustomerRepository;
import com.example.api.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CustomerInfraRepository implements CustomerRepository {

    private final CustomerSpringDataJPARepository customerSpringDataJPARepository;

    @Override
    public List<Customer> findAllByOrderByNameAsc() {
        return customerSpringDataJPARepository.findAllByOrderByNameAsc();
    }

    @Override
    public Object findById(Long id) {
        return customerSpringDataJPARepository.findById(id);
    }

    @Override
    public Customer salva(Customer customer) {
        log.info("[start] CustomerInfraRepository - salva");
        customerSpringDataJPARepository.save(customer);
        log.info("[finish] CustomerInfraRepository - salva");
        return customer;
    }
}
