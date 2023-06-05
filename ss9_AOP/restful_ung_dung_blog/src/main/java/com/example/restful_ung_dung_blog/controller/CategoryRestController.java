package com.example.restful_ung_dung_blog.controller;

import com.example.restful_ung_dung_blog.model.Blog;
import com.example.restful_ung_dung_blog.model.Category;
import com.example.restful_ung_dung_blog.service.IBlogService;
import com.example.restful_ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/admin/")

public class CategoryRestController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService ;



    @GetMapping("/search/category/{category}")
    public ResponseEntity<List<Blog>> getListByCategoryName(@PathVariable("category") String categoryName){
        List<Blog> blogList = iBlogService.findByCategory("%"+categoryName+"%");

        return new ResponseEntity<>(blogList, HttpStatus.OK);

    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategoryList(){
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }
}
