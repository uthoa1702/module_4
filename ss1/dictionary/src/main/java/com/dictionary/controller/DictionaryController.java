package com.dictionary.controller;


import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String home() {
        return "/index";
    }


    @PostMapping("/")
    public String translate(Model model, @RequestParam(value = "english") String english) {
        String viet = iDictionaryService.translate(english);
        model.addAttribute("english", english);
        model.addAttribute("viet", viet);
        return "/index";
    }
}
