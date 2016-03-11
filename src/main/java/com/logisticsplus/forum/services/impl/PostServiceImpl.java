package com.logisticsplus.forum.services.impl;

import com.logisticsplus.forum.entities.Post;
import com.logisticsplus.forum.repositories.PostRepository;
import com.logisticsplus.forum.services.PostService;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

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
        if (post.getTimestamp() == null) {
            post.setTimestamp(new Date());
        }

        return repository.save(post);
    }

    @Override
    public Post update(Post post) {
        return repository.save(post);
    }

    @Override
    public void delete(Post post) {
        repository.delete(post);
    }
}