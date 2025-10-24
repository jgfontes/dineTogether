package br.com.fiap.dine_together.dine_together.controller;

import br.com.fiap.dine_together.dine_together.dto.CreateUserRequest;
import br.com.fiap.dine_together.dine_together.dto.UpdateUserRequest;
import br.com.fiap.dine_together.dine_together.dto.UserDTO;
import br.com.fiap.dine_together.dine_together.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Controller", description = "Endpoints for managing users")
public class UserControllerImpl {

    @Autowired
    private UserService userService;

    @Operation(summary = "Create a new user")
    @ApiResponse(responseCode = "200", description = "User created")
    @PostMapping
    public UserDTO createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Get user by username")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public UserDTO getUserById(
            @Parameter(description = "Username of the user", required = true)
            @PathVariable UUID id) {
        return userService.getUserByUsername(id);
    }

    @Operation(summary = "Update an existing user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User updated"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/{id}")
    public UserDTO updateUser(
            @Parameter(description = "Username of the user to update", required = true)
            @PathVariable UUID id,
            @RequestBody UpdateUserRequest request) {
        return userService.updateUser(id, request);
    }

    @Operation(summary = "Delete a user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User deleted"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{username}")
    public void deleteUser(
            @Parameter(description = "Username of the user to delete", required = true)
            @PathVariable String username) {
        userService.deleteUser(username);
    }
}