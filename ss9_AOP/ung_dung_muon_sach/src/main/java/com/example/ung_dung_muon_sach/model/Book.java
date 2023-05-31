package com.example.ung_dung_muon_sach.model;


import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
public class Book implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    @Range(min = 0)
    private Integer quantity;

    public Book() {
    }

    public Book(Integer id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Book(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
