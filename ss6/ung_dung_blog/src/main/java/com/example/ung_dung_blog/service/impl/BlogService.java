package com.example.ung_dung_blog.service.impl;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.repository.IBlogRepository;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void create(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return  blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.delete(blogRepository.findById(id).get());
    }

    @Override
    public Page<Blog> getAllPage(Integer page) {
         return blogRepository.findAll(PageRequest.of(page, 1));
    }

    @Override
    public Page<Blog> findPage(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
