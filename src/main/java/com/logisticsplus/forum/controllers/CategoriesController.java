package com.logisticsplus.forum.controllers;

import com.logisticsplus.forum.entities.Category;
import com.logisticsplus.forum.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("categories")
@RestController
public class CategoriesController {

    @Autowired
    private CategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Category> index(Pageable pageable){
        return service.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category save(@Valid @RequestBody  Category category){
        return service.save(category);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Category update(@Valid @RequestBody  Category category){
        return service.save(category);
    }

    @RequestMapping(value = "/{id}/",method = RequestMethod.DELETE)
    public void delete(@PathVariable  Category id){

    }

    @RequestMapping(method = RequestMethod.GET)
    public Category findOne(@Valid @RequestBody  int id){
        return service.findOne(id);
    }
}
