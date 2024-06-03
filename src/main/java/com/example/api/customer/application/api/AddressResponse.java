package com.example.api.customer.application.api;

import com.example.api.customer.domain.Address;
import com.example.api.customer.domain.AddressType;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddressResponse {

    private String street;
    private Integer number;
    private String neighborhood;
    private String city;
    private String cep;
    private AddressType addressType;

    public AddressResponse(Address address) {
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.cep = address.getCep();
        this.addressType = address.getAddressType();
    }
}
