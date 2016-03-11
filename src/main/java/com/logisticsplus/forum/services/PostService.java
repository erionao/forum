package com.logisticsplus.forum.services;

import com.logisticsplus.forum.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    Page<Post> findAll(Pageable pageable);

    Post findOne(int id);

    Post save(Post post);

    Post update(Post Post);

    void delete(Post post);
}
