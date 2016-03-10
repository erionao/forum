package com.logisticsplus.forum.services.impl;

import com.logisticsplus.forum.entities.Post;
import com.logisticsplus.forum.repositories.PostRepository;
import com.logisticsplus.forum.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    public PostRepository repository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Post findOne(int id) {
        return repository.findOne(id);
    }

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    public Post update(Post post) {
        return repository.save(post);
    }

    @Override
    public void delete(Post post) {

    }
}
