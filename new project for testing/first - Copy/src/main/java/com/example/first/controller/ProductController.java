package com.example.first.controller;

import com.example.first.model.Product;
import com.example.first.model.TypeProduct;
import com.example.first.service.IProductService;
import com.example.first.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ITypeProductService iTypeProductService;


    @GetMapping("/")
    public String list(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList",productList);
        return "list";
    }
    @GetMapping("/create")
    public String createView(Model model){
        List<TypeProduct> typeProductList = iTypeProductService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("typeProductList",typeProductList);
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("product")Product product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            List<TypeProduct> typeProductList = iTypeProductService.findAll();
            model.addAttribute("typeProductList",typeProductList);
            return "create";
        }
        iProductService.save(product);
        return "redirect:/";

    }


    @PostMapping("/delete")
    public String delete(@RequestParam("productId") Integer id){
        iProductService.remove(id);
        return "redirect:/";
    }
}
