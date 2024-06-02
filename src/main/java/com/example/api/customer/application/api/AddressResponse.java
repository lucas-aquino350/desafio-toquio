package com.example.api.customer.application.api;

import com.example.api.customer.domain.Address;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddressResponse {

    private Long idAddress;

    public AddressResponse(Address address) {
        this.idAddress = address.getIdAddress();
    }
}
