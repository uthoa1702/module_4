package com.example.assignment.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Check(constraints = "price>0")
public class Product {
    // id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", columnDefinition = "TEXT", nullable = false)
    private String name;

    @NotNull
    @Column(name = "price")
    private Double price;
    @Column(name = "description",columnDefinition = "TEXT" ) private String description;
    @NotNull
    private String producer;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String description, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public Product(Integer id) {
        this.id = id;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
