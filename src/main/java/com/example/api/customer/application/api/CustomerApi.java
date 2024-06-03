package com.example.api.customer.application.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    Page<CustomerDetailedResponse> findAll(@PageableDefault(page = 0, size = 10) Pageable pageable );

    @PatchMapping("/{idCustomer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateCustomer(@PathVariable Long idCustomer, @Valid @RequestBody CustomerUpdateRequest customerUpdateRequest);

    @DeleteMapping("/{idCustomer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Long idCustomer);

    @PostMapping("/{idCustomer}/address")
    @ResponseStatus(HttpStatus.CREATED)
    AddressResponse registerAddressCustomer(@PathVariable Long idCustomer, @RequestBody AddressRequest addressRequest);

    @GetMapping("/listAddress/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    List<AddressListResponse> findAddressesByIdCustomer(@PathVariable Long idCustomer);

    @DeleteMapping("/{idCustomer}/address/{idAddress}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAddressCustomer(@PathVariable Long idCustomer, @PathVariable Long idAddress);

}
