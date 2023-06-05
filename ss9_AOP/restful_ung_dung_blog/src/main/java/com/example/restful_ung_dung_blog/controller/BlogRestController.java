package com.example.restful_ung_dung_blog.controller;

import com.example.restful_ung_dung_blog.model.Blog;
import com.example.restful_ung_dung_blog.model.Category;
import com.example.restful_ung_dung_blog.service.IBlogService;
import com.example.restful_ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getList(){
        return new ResponseEntity<>(iBlogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/blog/detail/{id}")
    public ResponseEntity<Blog> BlogDetail(@PathVariable("id") Integer id){
        return new ResponseEntity<>( iBlogService.findById(id), HttpStatus.OK);
    }


}
