package com.example.restful_ung_dung_blog.controller;

import com.example.restful_ung_dung_blog.model.Category;
import com.example.restful_ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/category")
    public String category(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList );
        return "category";
    }

    @GetMapping("/category/create")
    public String create(@ModelAttribute("category") Category category){
        return "create-category";
    }

    @GetMapping("/category/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "edit-category";
    }

    @GetMapping("/category/delete")
    public String delete(Model model, @RequestParam("deleteId") Integer id){
        categoryService.remove(id);
        return "redirect:/category";
    }



    @PostMapping("/category/create")
    public String createCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/category";
    }
}
