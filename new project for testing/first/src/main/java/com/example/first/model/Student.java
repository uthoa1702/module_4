package com.example.first.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "cant be blank")
    private String name;

    @ManyToOne
    @JoinColumn(name = "classes_id")
    private Class classes;


    @Column(nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(columnDefinition = "BIT DEFAULT 0")
    private boolean is_delete;

    public Student() {
    }

    public Student(String name, Class classes) {
        this.name = name;
        this.classes = classes;
    }

    public Student(Long id, String name, Class classes, LocalDateTime createTime, boolean is_delete) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.createTime = createTime;
        this.is_delete = is_delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }
}
