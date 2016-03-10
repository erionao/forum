package com.logisticsplus.forum.entities;

import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Category {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @NotEmpty
    @Size(min = 5,max = 15)
    @Column(name = "name",nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}