package com.example.api.customer.application.api;

import com.example.api.customer.domain.Address;
import com.example.api.customer.domain.AddressType;
import lombok.Getter;
import lombok.ToString;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class AddressListResponse {

    private Long idAddress;
    private String street;
    private Integer number;
    private String neighborhood;
    private String city;
    private String cep;
    private AddressType addressType;

    public AddressListResponse(Address address) {
        this.idAddress = address.getIdAddress();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.cep = address.getCep();
        this.addressType = address.getAddressType();
    }

    public static List<AddressListResponse> converteList(List<Address> listAddress) {
        return listAddress.stream()
                .map(AddressListResponse::new)
                .collect(Collectors.toList());
    }
}
