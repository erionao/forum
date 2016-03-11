package com.logisticsplus.forum.services.impl;

import com.logisticsplus.forum.entities.Category;
import com.logisticsplus.forum.repositories.CategoryRepository;
import com.logisticsplus.forum.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    @Override
    public Category findOne(int id) {
        return repository.findOne(id);
    }

    @Override
    public Category  save(Category  category ) {
        return repository.save(category );
    }

    @Override
    public Category update(Category category) {
        return repository.save(category);
    }

    @Override
    public void delete(Category category ) {
        repository.delete(category);
    }
}