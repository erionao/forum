package com.logisticsplus.forum.controllers;

import com.logisticsplus.forum.entities.Post;
import com.logisticsplus.forum.services.PostService;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RequestMapping("posts")
@RestController
public class PostsController {

    @Autowired
    public PostService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Post> index(Pageable pageable){
        return service.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Post save(@Valid @RequestBody Post post){
        if(post.getTimestamp()==null){
            post.setTimestamp(new Date());
        }
        return service.save(post);
    }

    @RequestMapping(value = "/{id}/",method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){

    }

    @RequestMapping(method = RequestMethod.PUT)
    public Post update(@Valid @RequestBody Post post){
        return service.save(post);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Post findOne(@Valid @RequestBody int id){
        return service.findOne(id);
    }
}
