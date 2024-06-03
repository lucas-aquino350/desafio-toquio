package com.example.api.customer.domain;

import com.example.api.customer.application.api.AddressRequest;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long idAddress;
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
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Address(AddressRequest addressRequest, Customer customer) {
        this.street = addressRequest.getStreet();
        this.number = addressRequest.getNumber();
        this.neighborhood = addressRequest.getNeighborhood();
        this.city = addressRequest.getCity();
        this.cep = addressRequest.getCep();
        this.addressType = addressRequest.getAddressType();
        this.customer = customer;
    }

    public void alterAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
