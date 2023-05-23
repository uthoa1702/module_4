package com.example.assignment.controller;


import com.example.assignment.model.Product;
import com.example.assignment.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Product> productList = new ArrayList<>();
        productList = productService.getList();
        model.addAttribute("products" , productList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model,@ModelAttribute("product") Product product){
        return "create";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,@PathVariable("id") Integer id){
        Product product = new Product();
        product = productService.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@ModelAttribute("product") Product product,Model model,@PathVariable("id") Integer id){
        boolean check = productService.delete(id);
        List<Product> productList = new ArrayList<>();
        productList = productService.getList();
        model.addAttribute("products" , productList);
        model.addAttribute("check",check);
        return "list";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id")Integer id){
        Product product = new Product();
        List<Product> productList = productService.getList();
        for (int i = 0; i < productList.size(); i++) {
            if (id== productList.get(i).getId()){
                 product = productList.get(i);
                break;
            }
        }
        model.addAttribute("product",product);
        return "edit";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        boolean check = productService.save(product);
        redirectAttributes.addFlashAttribute("check",check);
        return "redirect:/list";

    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        boolean check = productService.update(product);
        redirectAttributes.addFlashAttribute("check",check);
        return "redirect:list";

    }
    @PostMapping("/search")
    public String search(@RequestParam String search, Model model){
        List<Product> productList =  productService.search(search);
        model.addAttribute("products",productList);
        model.addAttribute("search",search);
        return "list";


    }


}
