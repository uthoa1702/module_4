package com.example.restful_ung_dung_blog.service;

import com.example.restful_ung_dung_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Integer id);

    void delete(Category category);

    void remove(Integer id);
}
