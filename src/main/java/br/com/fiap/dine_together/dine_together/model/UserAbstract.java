package br.com.fiap.dine_together.dine_together.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
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

    public abstract void setRole(ERole role);
}
