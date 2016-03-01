package com.logisticsplus.forum.repositories;

import com.logisticsplus.forum.entities.enums.UserRole;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.logisticsplus.forum.entities.User;

@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository< User, Integer> {
    User findById(Integer id);
    User findByEmail(String email);
    User findByRole(UserRole role);

}
