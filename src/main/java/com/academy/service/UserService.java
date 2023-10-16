package com.academy.service;

import com.academy.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(long id);

    void updateUser(User user);

    User getUserById(long id);
}
