package com.example.api.customer.application.api;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddressRequest {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;
}
