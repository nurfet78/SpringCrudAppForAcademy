package com.academy.repository;

import com.academy.model.User;
import com.academy.problem.NotFoundException;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {

        User user = entityManager.find(User.class, id);

        if (user == null) {
            throw new NotFoundException(User.class, id);
        }

        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {

        User user = entityManager.find(User.class, id);

        if (user == null) {
            throw new NotFoundException(User.class, id);
        }

        return user;
    }
}
