package com.example.api.customer.application.api;

import com.example.api.customer.domain.Customer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CustomerResponse {

    private Long idCustomer;

    public CustomerResponse(Customer customer) {
        this.idCustomer = customer.getId();
    }
}
