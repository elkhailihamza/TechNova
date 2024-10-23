package org.project.repository.implementations;

import org.project.model.User;
import org.project.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User fetchById(Long ID) {
        return null;
    }

    @Override
    public List<User> fetchAll() {
        return List.of();
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public User delete(User entity) {
        return null;
    }
}
