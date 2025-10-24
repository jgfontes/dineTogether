package br.com.fiap.dine_together.dine_together.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Address {
    String street;
    String number;
    String city;
    String cep;
}
