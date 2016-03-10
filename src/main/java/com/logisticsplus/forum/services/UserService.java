package com.logisticsplus.forum.services;

import com.logisticsplus.forum.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> findAll (Pageable pageable);


    User findOne(int id);

    User save(User user);

    void delete(User user);

    User update(User user);


}



