package com.logisticsplus.forum.repositories;
import com.logisticsplus.forum.entities.Category;
import com.logisticsplus.forum.entities.enums.UserRole;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository("categoryRepository")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

}