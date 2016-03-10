package com.logisticsplus.forum.services;

import com.logisticsplus.forum.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<Category> findAll (Pageable pageable);

    Category findOne(int id);

    Category update(Category category);

    void delete(Category category);

    Category save(Category category);
}



