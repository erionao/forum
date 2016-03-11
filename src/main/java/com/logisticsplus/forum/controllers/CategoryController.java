package com.logisticsplus.forum.controllers;

import com.logisticsplus.forum.entities.Category;
import com.logisticsplus.forum.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping("category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Category> index(Pageable pageable){
        return service.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category save(@RequestBody Category category){
        return service.save(category);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Category update(@RequestBody Category category){
        return service.save(category);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable int id){
        service.delete(service.findOne(id));
    }
}
