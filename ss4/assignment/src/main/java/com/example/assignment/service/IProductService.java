package com.example.assignment.service;

import com.example.assignment.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();

    boolean save(Product product);

    boolean update(Product product);

    boolean delete(Integer id);

    Product findById(Integer id);

    List<Product> search(String search);
}
