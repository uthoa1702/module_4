package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.service.IBlogService;
import com.example.ung_dung_blog.service.ICategoryService;
import com.example.ung_dung_blog.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
public class BlogController {


    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;



//    @GetMapping("/search")
//    public String search(@RequestParam("searchText") String searchText, Model model) {
//        // Gọi hàm tìm kiếm từ Repository
//        List<Blog> searchResult = blogService.findByNameContainingIgnoreCase(searchText);
//        // Truyền kết quả tìm kiếm vào model
//        model.addAttribute("blogList", searchResult);
//        // Trả về template hiển thị kết quả tìm kiếm
//        return "blogList";
//    }


    @GetMapping("/")
    public String paginate(Model model, @RequestParam(value = "p", defaultValue = "0")Optional<Integer> p){
        Pageable pageable = PageRequest.of(p.orElse(0),2);
        Page<Blog> page = blogService.findPage(pageable);
        model.addAttribute("blogList", page);
        return "blogList";
    }


    @GetMapping("/create")
    public String create(Model model, @ModelAttribute ("blog") Blog blog){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "create";
    }
    @GetMapping("/edit/{id}")
    public String create(Model model, @PathVariable ("id") Integer id){
        model.addAttribute("blog",blogService.findById(id));
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "edit";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable ("id") Integer id){
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("deleteId") Integer id){
        blogService.delete(id);
        return "redirect:/";
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
