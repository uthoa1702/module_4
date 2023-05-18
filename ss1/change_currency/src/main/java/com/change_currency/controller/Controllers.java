package com.change_currency.controller;


import com.change_currency.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {
    @Autowired
    IConvertService iConvertService;
    @GetMapping("/")
    public String form(){
        return "/index";
    }

    @PostMapping("/")
    public String convert(Model model, @RequestParam(value = "usd")int usd, @RequestParam(value = "vnd")int vnd){

        int result =  iConvertService.usdToVnd(usd,vnd);

            model.addAttribute("vnd",vnd);
            model.addAttribute("usd",usd);
            model.addAttribute("result",result);


        return "/index";
    }
}
