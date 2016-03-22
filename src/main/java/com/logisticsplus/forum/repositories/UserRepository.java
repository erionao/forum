package com.logisticsplus.forum.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.logisticsplus.forum.entities.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    User findByEmail(String login);

}
