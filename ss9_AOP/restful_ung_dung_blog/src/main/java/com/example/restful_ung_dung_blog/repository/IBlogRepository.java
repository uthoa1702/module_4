package com.example.restful_ung_dung_blog.repository;


import com.example.restful_ung_dung_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {


    @Query(value = "select b from Blog b where b.category.name like :categoryName")
    List<Blog> findByCategory(String categoryName);
}
