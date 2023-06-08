package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "classroom")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_class", columnDefinition = "VARCHAR(50)")
    private String nameClass;

//    @OneToMany(mappedBy = "classRoom")
//    List<Student> students;
//
    public ClassRoom() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
