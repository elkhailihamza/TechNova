package org.project.service;

import org.project.model.User;

public class UserService {
    public User getUser() {
        return new User("username", "password");
    }
}
