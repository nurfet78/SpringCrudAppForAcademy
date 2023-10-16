package com.academy.service;

import com.academy.model.User;
import com.academy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }


    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }
}
