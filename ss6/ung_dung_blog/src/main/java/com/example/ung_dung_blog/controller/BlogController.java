package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {


    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ModelAndView getList() {

        return new ModelAndView("blogList", "blogList", blogService.findAll());
    }

    @GetMapping("/create")
    public String create(Model model, @ModelAttribute ("blog") Blog blog){
//        model.addAttribute("blog",new Blog());
        return "create";
    }
    @GetMapping("/edit/{id}")
    public String create(Model model, @PathVariable ("id") Integer id){
        model.addAttribute("blog",blogService.findById(id));
        return "edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("deleteId") Integer id){
        blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable ("id") Integer id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes, Model model) {
        blogService.create(blog);
//        redirectAttributes.addFlashAttribute("blogList", blogService.findAll());
//        model.addAttribute("blogList",blogService.findAll());
        return "redirect:/";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute ("blog") Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }
}
