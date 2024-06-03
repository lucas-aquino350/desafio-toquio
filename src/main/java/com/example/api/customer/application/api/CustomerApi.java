package com.example.api.customer.application.api;

import com.example.api.customer.domain.Address;
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

    @GetMapping("/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    CustomerDetailedResponse findById( @PathVariable Long idCustomer);

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    List<CustomerDetailedResponse> findAll();

    @PatchMapping("/{idCustomer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateCustomer(@PathVariable Long idCustomer, @RequestBody CustomerUpdateRequest customerUpdateRequest);

    @DeleteMapping("/{idCustomer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Long idCustomer);

    @PostMapping("/{idCustomer}/address")
    @ResponseStatus(HttpStatus.CREATED)
    AddressResponse registerAddressCustomer(@PathVariable Long idCustomer, @RequestBody AddressRequest addressRequest);

    @GetMapping("/listAddress/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    List<AddressListResponse> findAddressesByIdCustormer ( @PathVariable Long idCustomer);

}