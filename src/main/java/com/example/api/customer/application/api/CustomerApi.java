package com.example.api.customer.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("v1/customer")
public interface CustomerApi {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CustomerResponse registerCustomer( @Valid @RequestBody CustomerRequest customerRequest);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CustomerDetailedResponse findById( @PathVariable Long id);

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    List<CustomerDetailedResponse> findAll();

}