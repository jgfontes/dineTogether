package br.com.fiap.dine_together.dine_together.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class UserAbstract {
    UUID id;
    String name;
    String email;
    String username;
    String password;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Address address;
    ERole role;

    abstract void setRole(ERole role);
}
