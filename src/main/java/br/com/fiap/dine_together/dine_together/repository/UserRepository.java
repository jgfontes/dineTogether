package br.com.fiap.dine_together.dine_together.repository;

import br.com.fiap.dine_together.dine_together.model.UserAbstract;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    List<UserAbstract> findAll();
    UserAbstract findById(UUID id);
    void save(UserAbstract user);
    void deleteByUsername(String username);
}