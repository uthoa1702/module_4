package com.example.hom_thu_dien_tu.controller;

import com.example.hom_thu_dien_tu.model.EmailContainer;
import com.example.hom_thu_dien_tu.service.IEmailContainerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailContainerController {
    @Autowired
    IEmailContainerService emailContainerService;

    @GetMapping("/")
    public  String home (){
        return "index";
    }

    @GetMapping("/setting")
    public String setting(Model model) {
        String[] languages = {"English", "Vietnamese", "Chinese", "Japanese", "Korean"};
        Integer[] pageSizes = {5, 10, 15, 25, 50, 100};
        EmailContainer showSetting = emailContainerService.showSetting();
        model.addAttribute("emailContainer", showSetting);
        model.addAttribute("languages", languages);
        model.addAttribute("pageSizes", pageSizes);
        return "setting";
    }

    @PostMapping("update")
    public String updateEmailContainer(@ModelAttribute("emailContainer") EmailContainer emailContainer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        EmailContainer emailContainer1 = new EmailContainer();
        BeanUtils.copyProperties(emailContainer, emailContainer1);
        emailContainerService.save(emailContainer1);
        return "index";
    }
}
