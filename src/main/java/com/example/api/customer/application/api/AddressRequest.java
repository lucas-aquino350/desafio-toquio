package com.example.api.customer.application.api;

import com.example.api.customer.domain.AddressType;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@ToString
public class AddressRequest {

    @NotBlank
    private String rua;
    @NotNull
    private Integer numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String cep;
    @NotNull
    private AddressType addressType;
}
