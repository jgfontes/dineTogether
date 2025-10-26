package br.com.fiap.dine_together.dine_together.service;

import br.com.fiap.dine_together.dine_together.dto.CreateUserRequest;
import br.com.fiap.dine_together.dine_together.dto.UpdateUserRequest;
import br.com.fiap.dine_together.dine_together.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(UUID id);
    UserDTO createUser(CreateUserRequest request);
    UserDTO updateUser(UUID id, UpdateUserRequest request);
    void deleteUser(String id);
}
