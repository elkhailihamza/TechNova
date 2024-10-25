package org.project.service;

import org.project.model.User;
import org.project.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User fetchById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> fetchAll() {
        return userRepository.findAll();
    }

    public User save(User entity) {
        return userRepository.save(entity);
    }

    public User update(User entity) {
        if (!userRepository.existsById(entity.getId())) {
            return null;
        }
        return userRepository.save(entity);
    }

    public void delete(User entity) {
        userRepository.delete(entity);
    }
}
