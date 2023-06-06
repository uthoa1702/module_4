package com.example.login_blog.service;


import com.example.login_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Integer id);

    void delete(Category category);

    void remove(Integer id);
}
