package com.example.api.customer.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/customer")
public interface CustomerApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CustomerResponse registerCustomer(@RequestBody CustomerRequest customerRequest);


}
