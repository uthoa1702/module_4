package com.example.login_blog.service;


import com.example.login_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBlogService {

    void create(Blog blog);

    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void delete(Integer id);

    Page<Blog> getAllPage(Integer page);

    Page<Blog> findPage(Pageable pageable);

    List<Blog> getListOfObjectFromDbBasedOnQuery(String query);

    List<Blog> findByNameContainingIgnoreCase(String searchText);

    Slice<Blog> findAllBlogBySlice(Integer page);
}
