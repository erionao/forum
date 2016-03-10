package com.logisticsplus.forum.repositories;

import com.logisticsplus.forum.entities.Post;
import com.logisticsplus.forum.entities.enums.UserRole;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository("postRepository")
public interface PostRepository extends PagingAndSortingRepository<Post , Integer> {

}
