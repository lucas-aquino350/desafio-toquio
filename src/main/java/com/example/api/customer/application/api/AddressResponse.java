package com.example.api.customer.application.api;

import com.example.api.customer.domain.Address;
import com.example.api.customer.domain.AddressType;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddressResponse {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;
    private AddressType addressType;

    public AddressResponse(Address address) {
        this.rua = address.getRua();
        this.numero = address.getNumero();
        this.bairro = address.getBairro();
        this.cidade = address.getCidade();
        this.cep = address.getCep();
        this.addressType = address.getAddressType();
    }
}
