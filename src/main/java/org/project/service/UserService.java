package org.project.service;

import org.project.model.User;
import org.project.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User fetchById(long id) {
        return userRepository.fetchById(id);
    }

    public List<User> fetchAll() {
        return userRepository.fetchAll();
    }

    public User save(User entity) {
        return userRepository.save(entity);
    }

    public User update(User entity) {
        return userRepository.update(entity);
    }

    public User delete(User user) {
        return userRepository.delete(user);
    }
}
