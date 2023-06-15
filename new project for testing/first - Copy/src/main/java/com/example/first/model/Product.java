package com.example.first.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "cant be blank")
    private String name;

    @ManyToOne
    @JoinColumn
    private TypeProduct typeProduct;

    public Product() {
    }

    public Product(String name, TypeProduct typeProduct) {
        this.name = name;
        this.typeProduct = typeProduct;
    }

    public Product(Integer id, String name, TypeProduct typeProduct) {
        this.id = id;
        this.name = name;
        this.typeProduct = typeProduct;
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

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }
}
