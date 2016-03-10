package com.logisticsplus.forum.services.impl;
import com.logisticsplus.forum.entities.User;
import com.logisticsplus.forum.repositories.UserRepository;
import com.logisticsplus.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public User findOne(int id) {
        return repository.findOne(id);
    }


    @Override
    public User save(User user) {

        return repository.save(user);
    }

    @Override
    public void delete(User id){
    }

    @Override
    public User update(User user) {

        return repository.save(user);
    }


}
