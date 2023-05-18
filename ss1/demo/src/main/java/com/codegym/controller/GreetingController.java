package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    @RequestMapping(value = "/greeting/{name}",method = RequestMethod.GET)
    public String name(Model model,@PathVariable("name") String name){
        model.addAttribute("name", name);
        return "index";
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}