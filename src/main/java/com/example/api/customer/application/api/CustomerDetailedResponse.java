package com.example.api.customer.application.api;

import com.example.api.customer.domain.Customer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CustomerDetailedResponse {

    private Long id;
    private String name;
    private String email;

    public CustomerDetailedResponse(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
    }
}
