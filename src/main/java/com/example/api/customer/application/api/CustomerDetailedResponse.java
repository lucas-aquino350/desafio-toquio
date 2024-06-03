package com.example.api.customer.application.api;

import com.example.api.customer.domain.Address;
import com.example.api.customer.domain.Customer;
import lombok.Getter;
import lombok.ToString;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@ToString
public class CustomerDetailedResponse {

    private Long idCustomer;
    private String name;
    private String email;
    private AddressResponse address;

    public CustomerDetailedResponse(Customer customer) {
        this.idCustomer = customer.getIdCustomer();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.address = converte(customer.getPrincipalAddress());
    }

    private AddressResponse converte(Optional<Address> principalAddress) {
        return principalAddress
                .map(AddressResponse::new)
                .orElse(null);
    }

    public static List<CustomerDetailedResponse> converteList(List<Customer> listCustomer) {
        return listCustomer.stream()
                .map(CustomerDetailedResponse::new)
                .collect(Collectors.toList());
    }
}
