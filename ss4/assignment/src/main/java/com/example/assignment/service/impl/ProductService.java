package com.example.assignment.service.impl;

import com.example.assignment.model.Product;
import com.example.assignment.repository.IProductRepository;
import com.example.assignment.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired private IProductRepository productRepository;

    @Override
    public List<Product> getList() {
        return productRepository.getList();
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productRepository.delete(id);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> search(String search) {
        return productRepository.search(search);
    }
}
