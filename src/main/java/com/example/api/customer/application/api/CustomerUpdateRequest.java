package com.example.api.customer.application.api;

import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.Email;

@Getter
@ToString
public class CustomerUpdateRequest {

    private String name;
    @Email
    private String email;
}
