package org.project.service;

import org.project.model.User;

public class UserServiceImpl implements UserService{
    @Override
    public User getUser() {
        return new User("username", "password");
    }
}
