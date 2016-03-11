package com.logisticsplus.forum.entities;

import com.logisticsplus.forum.entities.enums.UserRole;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
    public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @NotNull
    @Size(min = 3, max = 21)
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty
    @NotNull
    @Size(min = 5, max = 15)
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty
    @NotNull
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
