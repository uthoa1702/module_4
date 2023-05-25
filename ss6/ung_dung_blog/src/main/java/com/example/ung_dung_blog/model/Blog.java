package com.example.ung_dung_blog.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String title;
    @NotNull
    private String author;
    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(name = "createTime", nullable = false,updatable = false)
    @CreationTimestamp
    private Date createTime;

    @Column(name = "updateTime", nullable = false,updatable = true)
    @UpdateTimestamp
    private Date updateTime;

    public Blog() {
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
