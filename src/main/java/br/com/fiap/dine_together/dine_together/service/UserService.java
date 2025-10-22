package br.com.fiap.dine_together.dine_together.service;

import br.com.fiap.dine_together.dine_together.dto.CreateUserRequest;
import br.com.fiap.dine_together.dine_together.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserByUsername(String username);
    UserDTO createUser(CreateUserRequest request);
    UserDTO updateUser(String username, CreateUserRequest request);
    void deleteUser(String username);
}
