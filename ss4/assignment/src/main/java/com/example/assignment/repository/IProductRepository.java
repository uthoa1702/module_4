package com.example.assignment.repository;


import com.example.assignment.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getList();

    boolean save(Product product);

    boolean update(Product product);

    boolean delete(Integer id);

    Product findById(Integer id);

    List<Product> search(String search);
}
