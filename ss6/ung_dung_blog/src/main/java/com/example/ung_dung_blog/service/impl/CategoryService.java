package com.example.ung_dung_blog.service.impl;

import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.repository.ICategoryRepository;
import com.example.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return  categoryRepository.findById(id).get();
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Transactional
    @Override
    public void remove(Integer id) {
        categoryRepository.deleteById(id);
    }
}
