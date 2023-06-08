package com.example.login_blog.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Blog {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String title;

    @Column(name = "status" , columnDefinition = "BIT DEFAULT 0")
    private Boolean status;
    @NotNull
    private String author;
    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(name = "createTime", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private Date createTime;

    @Column(name = "updateTime", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private Date updateTime;

    @ManyToOne
    @JoinColumn
    private Category category;

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Blog(Integer id, String title, String author, String content, Date createTime, Date updateTime, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.category = category;
    }

    public Blog(String title, Boolean status, String author, String content, Date createTime, Date updateTime, Category category) {
        this.title = title;
        this.status = status;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.category = category;
    }

    public Blog(Integer id, String title, Boolean status, String author, String content, Date createTime, Date updateTime, Category category) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.category = category;
    }

    public Blog(String title, String author, String content, Date createTime, Date updateTime, Category category) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(Integer id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Blog(Integer id, String title, String author, String content, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Blog(String title, String author, String content, Date createTime, Date updateTime) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
