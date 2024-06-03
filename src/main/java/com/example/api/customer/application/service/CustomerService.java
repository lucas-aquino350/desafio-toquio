package com.example.api.customer.application.service;

import com.example.api.customer.application.api.*;
import com.example.api.customer.domain.Customer;
import java.util.List;

public interface CustomerService {
    CustomerResponse registerCustomer(CustomerRequest customerRequest);

    CustomerDetailedResponse findById(Long idCustomer);

    List<CustomerDetailedResponse> findAll();

    void updateCustomer(Long idCustomer, CustomerUpdateRequest customerUpdateRequest);

    void deleteCustomer(Long idCustomer);

    AddressResponse registerAddressCustomer(Long idCustomer, AddressRequest addressRequest);

    List<AddressListResponse> findAddressesByIdCustormer(Long idCustomer);
}
