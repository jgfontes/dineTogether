package br.com.fiap.dine_together.dine_together.repository;

import br.com.fiap.dine_together.dine_together.model.UserAbstract;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MockedUserRepository implements UserRepository {

    private final Map<UUID, UserAbstract> users = new ConcurrentHashMap<>();

    @Override
    public List<UserAbstract> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public UserAbstract findById(UUID id) {
        return users.get(id);
    }

    @Override
    public void save(UserAbstract user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        users.put(user.getId(), user);
    }

    @Override
    public void deleteByUsername(String username) {
        users.values().removeIf(user -> username.equals(user.getUsername()));
    }
}