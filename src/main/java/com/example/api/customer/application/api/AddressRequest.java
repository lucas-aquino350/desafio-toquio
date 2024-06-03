package com.example.api.customer.application.api;

import com.example.api.customer.domain.AddressType;
import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@ToString
public class AddressRequest {

    @NotBlank
    private String street;
    @NotNull
    private Integer number;
    @NotBlank
    private String neighborhood;
    @NotBlank
    private String city;
    @NotBlank
    private String cep;
    @NotNull
    private AddressType addressType;

}
