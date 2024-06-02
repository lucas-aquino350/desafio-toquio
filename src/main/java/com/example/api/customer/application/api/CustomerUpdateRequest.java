package com.example.api.customer.application.api;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@ToString
public class CustomerUpdateRequest {

    private String name;
    @Email
    private String email;
}
