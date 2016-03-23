package com.logisticsplus.forum.services.impl;

import com.logisticsplus.forum.entities.User;
import com.logisticsplus.forum.exceptions.ForumException;
import com.logisticsplus.forum.exceptions.ForumNotFoundException;
import com.logisticsplus.forum.repositories.UserRepository;
import com.logisticsplus.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User findOne(int id) throws ForumNotFoundException {
        User user = repository.findOne(id);

        if (user == null) {
            throw new ForumNotFoundException("User with code '" + id + "' was not found.");
        }

        return user;
    }

    @Override
    public User save(User user) throws ForumException {
        if (repository.findOne(user.getId()) != null) {
            throw new ForumException("User with code '" + user.getId() + "' already exists");
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return repository.save(user);
    }

    @Override
    public User update(User user) {
        if (!user.getEmail().equals(repository.findOne(user.getId()).getEmail()) && repository.findByEmail(user.getEmail()) != null) {
            throw new ForumException("A user with the same login already exists.");
        }

        if (!user.getPassword().equals("")) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }

        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public User findByEmail(String login){
        return repository.findByEmail(login);
    }

}


