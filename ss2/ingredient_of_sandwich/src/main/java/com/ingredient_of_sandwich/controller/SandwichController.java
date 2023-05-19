package com.ingredient_of_sandwich.controller;


import com.ingredient_of_sandwich.model.Sandwich;
import com.ingredient_of_sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {
    @Autowired
    ISandwichService sandwichService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/add")
    public String save(Model model,@RequestParam String[] ingredient,RedirectAttributes redirectAttributes) {

            model.addAttribute("list",ingredient);

        return "index";
    }
}
