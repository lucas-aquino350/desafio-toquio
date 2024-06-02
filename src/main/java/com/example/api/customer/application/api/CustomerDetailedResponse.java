package com.example.api.customer.application.api;

import com.example.api.customer.domain.Customer;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<CustomerDetailedResponse> converte(List<Customer> listCustomer) {
        return listCustomer.stream()
                .map(CustomerDetailedResponse::new)
                .collect(Collectors.toList());
    }
}
