package com.logisticsplus.forum.controllers;

import com.logisticsplus.forum.entities.User;
import com.logisticsplus.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("users") // http://localhost:8080/users
@RestController
public class UsersController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<User> index(Pageable pageable) {

        return service.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User save(@Valid @RequestBody User user) {

        return service.save(user);
    }


    @RequestMapping(value = "/{id}/" , method = RequestMethod.DELETE)
    public void delete(@PathVariable User id){
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User update(@Valid @RequestBody  User user){

        return service.save(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public User findOne(@Valid @RequestBody int id){
        return service.findOne(id);
    }


}


