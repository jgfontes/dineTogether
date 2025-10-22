package br.com.fiap.dine_together.dine_together.dto;

import br.com.fiap.dine_together.dine_together.model.Address;
import br.com.fiap.dine_together.dine_together.model.ERole;

public class UpdateUserRequest {
    public String name;
    public String email;
    public Address address;
    public ERole role;
}
