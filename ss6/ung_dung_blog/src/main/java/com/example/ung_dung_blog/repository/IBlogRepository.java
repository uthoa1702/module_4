package com.example.ung_dung_blog.repository;


import com.example.ung_dung_blog.model.Blog;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select b from Blog b where b.title like :title")
    List<Blog> getListOfObjectFromDbBasedOnQuery(@Param("title") String title);
//    @Query(value = "select b from Blog b where b.title like :searchText")
//    List<Blog> findByNameContainingIgnoreCase(String searchText);
    @Query(value = "select b from Blog b ")
    Slice<Blog> findAllBlog(Pageable pageable);
}
