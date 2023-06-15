package com.example.first.service;

import com.example.first.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    void remove(Integer id);
}
