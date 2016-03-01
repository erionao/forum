package com.logisticsplus.forum.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.logisticsplus.forum.entities.Category;

@Repository("categoryRepository")
public interface CategoryRepository extends PagingAndSortingRepository< Category, Integer> {

    Category findById(Integer id);
    Category findByName(String name);
}


