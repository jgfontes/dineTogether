package br.com.fiap.dine_together.dine_together.service;

import br.com.fiap.dine_together.dine_together.dto.CreateUserRequest;
import br.com.fiap.dine_together.dine_together.dto.UpdateUserRequest;
import br.com.fiap.dine_together.dine_together.dto.UserDTO;
import br.com.fiap.dine_together.dine_together.exception.EntityNotFound;
import br.com.fiap.dine_together.dine_together.model.UserAbstract;
import br.com.fiap.dine_together.dine_together.repository.UserRepository;
import br.com.fiap.dine_together.dine_together.util.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private void updateUserFromRequest(UserAbstract user, UpdateUserRequest req) {
        if (req.getName() != null) user.setName(req.getName());
        if (req.getEmail() != null) user.setEmail(req.getEmail());
        if (req.getAddress() != null) user.setAddress(req.getAddress());
        if (req.getRole() != null) user.setRole(req.getRole());
        user.setUpdatedAt(LocalDateTime.now());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserAbstract> users = userRepository.findAll();
        return users.stream()
                .map(EntityDtoMapper::mapDtoToUser)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByUsername(UUID id) {
        UserAbstract user = userRepository.findById(id);

        if (user == null) {
            throw new EntityNotFound("User not found with id: " + id);
        }

        return EntityDtoMapper.mapDtoToUser(user);
    }

    @Override
    public UserDTO createUser(CreateUserRequest request) {
        UserAbstract user = EntityDtoMapper.mapUserFromCreateRequest(request);
        userRepository.save(user);
        return EntityDtoMapper.mapDtoToUser(user);
    }

    @Override
    public UserDTO updateUser(UUID id, UpdateUserRequest request) {
        UserAbstract user = userRepository.findById(id);

        if (user == null) {
            throw new EntityNotFound("User not found with id: " + id);
        }

        updateUserFromRequest(user, request);
        userRepository.save(user);

        return EntityDtoMapper.mapDtoToUser(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }
}