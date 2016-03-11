package com.logisticsplus.forum.entities;

import com.logisticsplus.forum.entities.Category;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp", nullable = false)
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "parent", nullable = false)
    private Post parent;

    @NotEmpty
    @NotNull
    @Size(min=8, max = 30)
    @Column(name = "title", nullable = false)
    private String title;


    @NotEmpty
    @NotNull
    @Size(min=8, max = 300)
    @Column(name = "body", nullable = false)
    private String body;


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
