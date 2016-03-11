package com.logisticsplus.forum.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.logisticsplus.forum.entities.Post;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
}

