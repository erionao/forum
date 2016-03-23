package com.logisticsplus.forum.services;

import com.logisticsplus.forum.entities.User;
import com.logisticsplus.forum.exceptions.ForumException;
import com.logisticsplus.forum.exceptions.ForumNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface UserService {

    Page<User> findAll(Pageable pageable);

    User findOne(int id) throws ForumNotFoundException;

    User save(User user)throws ForumException;

    User update(User user);

    void delete(User user);

    User findByEmail (String login);

}
