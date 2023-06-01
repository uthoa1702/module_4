package com.example.shop_hoa.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private Integer code;

    @NotNull
    private String name ;


    @NotNull
    private Double price;


    private String description;

    private String image;

    public Flower(Integer id, Integer code, String name, Double price, String description, String image) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Flower() {
    }

    public Flower(Integer id) {
        this.id = id;
    }

    public Flower(Integer code, String name, Double price, String description, String image) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
