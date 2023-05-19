package com.example.calculator.controller;


import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @PostMapping ("/calculator")
    public String calculate(@RequestParam Integer num1, @RequestParam Integer num2, @RequestParam String action, Model model){
        int result;
        switch (action){
            case "add":
                result = calculatorService.add(num1,num2);
                model.addAttribute("action", "Addition");
                model.addAttribute("result", result);
                break;
            case "sub":
                result = calculatorService.sub(num1,num2);
                model.addAttribute("action", "Subtraction");
                model.addAttribute("result", result);
                break;
            case "div":
                result = calculatorService.div(num1,num2);
                model.addAttribute("action", "Division");
                model.addAttribute("result", result);
                break;
            case "mul":
                result = calculatorService.mul(num1,num2);
                model.addAttribute("action", "Multiplication");
                model.addAttribute("result", result);
                break;
        }





        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "index";
    }
}
