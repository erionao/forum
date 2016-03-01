package com.logisticsplus.forum.repositories;


import com.logisticsplus.forum.entities.Category;
import com.logisticsplus.forum.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.logisticsplus.forum.entities.Post;

@Repository("postRepository")
public interface PostRepository extends PagingAndSortingRepository< Post, Integer> {
    Post findById(Integer id);
    Post findByTitle(String title);
    Post findByUser(User author); // per qita nuk jom shume e sigurte
    Post findByCategory(Category category);
}

