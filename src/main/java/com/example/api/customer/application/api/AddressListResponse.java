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
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;
    private AddressType addressType;

    public AddressListResponse(Address address) {
        this.idAddress = address.getIdAddress();
        this.rua = address.getRua();
        this.numero = address.getNumero();
        this.bairro = address.getBairro();
        this.cidade = address.getCidade();
        this.cep = address.getCep();
        this.addressType = address.getAddressType();
    }

    public static List<AddressListResponse> converteList(List<Address> listAddress) {
        return listAddress.stream()
                .map(AddressListResponse::new)
                .collect(Collectors.toList());
    }
}
