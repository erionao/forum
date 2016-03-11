package com.logisticsplus.forum.controllers;

import com.logisticsplus.forum.entities.Post;
import com.logisticsplus.forum.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping("posts")
@RestController
public class PostController {
    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Post> index(Pageable pageable){
        return service.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Post save(@RequestBody Post post){
        return service.save(post);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Post update(@RequestBody Post post){
        return service.save(post);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable int id){
        service.delete(service.findOne(id));
    }
}

