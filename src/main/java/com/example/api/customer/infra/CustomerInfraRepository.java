package com.example.api.customer.infra;

import com.example.api.customer.application.repository.CustomerRepository;
import com.example.api.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CustomerInfraRepository implements CustomerRepository {

    private final CustomerSpringDataJPARepository customerSpringDataJPARepository;

    @Override
    public Customer salva(Customer customer) {
        log.info("[start] CustomerInfraRepository - salva");
        try {
            customerSpringDataJPARepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is duplicate data!");
        }
        log.info("[finish] CustomerInfraRepository - salva");
        return customer;
    }

    @Override
    public Customer findById(Long idCustomer) {
        log.info("[start] CustomerInfraRepository - findById");
        Customer customer = customerSpringDataJPARepository.findById(idCustomer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found!"));
        log.info("[finish] CustomerInfraRepository - findById");
        return customer;
    }

    @Override
    public Page<Customer> findAllByOrderByNameAsc(Pageable pageable) {
        log.info("[start] CustomerInfraRepository - findAll");
        Page<Customer> lisCustomer = customerSpringDataJPARepository.findAllByOrderByNameAsc(pageable);
        log.info("[finish] CustomerInfraRepository - findAll");
        return lisCustomer;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        log.info("[start] CustomerInfraRepository - deleteCustomer");
        customerSpringDataJPARepository.delete(customer);
        log.info("[finish] CustomerInfraRepository - deleteCustomer");
    }
}
