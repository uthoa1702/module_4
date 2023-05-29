package com.example.sign_up_form.controller;

import com.example.sign_up_form.DTO.UserDTO;

import com.example.sign_up_form.model.User;
import com.example.sign_up_form.service.ISignUpFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    @Autowired
    private ISignUpFormService service;
    @GetMapping("/")
    public String form(Model model, @ModelAttribute("user") UserDTO userDTO){
        return "sign-up-form";
    }

    @GetMapping("/result")
    public String result(Model model, @ModelAttribute("user") UserDTO userDTO){
        return "result";
    }

    @PostMapping("/create")
    public String create(@Validated  @ModelAttribute ("user") UserDTO userDTO, BindingResult bindingResult){
       new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "sign-up-form";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            service.save(user);
            return "redirect:/result";
        }

    }
}
