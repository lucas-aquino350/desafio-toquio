package com.example.api.customer.domain;

import com.example.api.customer.application.api.AddressRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long idAddress;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Address(AddressRequest addressRequest, Customer customer) {
        this.rua = addressRequest.getRua();
        this.numero = addressRequest.getNumero();
        this.bairro = addressRequest.getBairro();
        this.cidade = addressRequest.getCidade();
        this.cep = addressRequest.getCep();
        this.customer = customer;
    }
}
