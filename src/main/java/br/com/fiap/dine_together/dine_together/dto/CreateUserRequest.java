package br.com.fiap.dine_together.dine_together.dto;

import br.com.fiap.dine_together.dine_together.model.Address;
import br.com.fiap.dine_together.dine_together.model.ERole;

public class CreateUserRequest {
    public String name;
    public String email;
    public String username;
    public String password;
    public Address address;
    public ERole role;
}
