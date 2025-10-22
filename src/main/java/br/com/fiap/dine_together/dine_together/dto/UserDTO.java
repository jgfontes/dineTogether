package br.com.fiap.dine_together.dine_together.dto;

import br.com.fiap.dine_together.dine_together.model.Address;
import br.com.fiap.dine_together.dine_together.model.ERole;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserDTO {
    UUID id;
    String name;
    String email;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Address address;
    ERole role;
}
