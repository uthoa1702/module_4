package com.example.shop_hoa.controller;

import com.example.shop_hoa.model.Flower;
import com.example.shop_hoa.service.ICartService;
import com.example.shop_hoa.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@SessionAttributes("cart")
public class FlowerController {
    @Autowired
    private IFlowerService iFlowerService;
    @Autowired
    private ICartService iCartService;

    @GetMapping("/")
    public String home(Model model) {
        List<Flower> flowerList = iFlowerService.getList();
        model.addAttribute("flowerList", flowerList);
        return "home";
    }

    @ModelAttribute("cart")
    public Map<Flower, Integer> initCart() {
        return new LinkedHashMap<>();
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        Flower flower = iFlowerService.findById(id);
        model.addAttribute("flower", flower);
        return "detail";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes,
                            @ModelAttribute("cart") Map<Flower, Integer> flowerList) {
        Flower flower = iFlowerService.findById(id);
        if (!iCartService.checkExist(flower, flowerList)) {
            flowerList.put(flower, 1);
        } else {
            Map.Entry<Flower,Integer> m = iCartService.flowerIntegerEntry(flower,flowerList);

            Integer quantity = m.getValue() + 1;
            flowerList.replace(m.getKey(),quantity);
        }
        redirectAttributes.addFlashAttribute("mess", "ADDED");

        return "redirect:/";
    }





//    @GetMapping("/cart")
//    public String cart(@SessionAttribute("cart") List<Flower> list , Model model){
//        model.addAttribute("cart",list);
//        return "shopping-cart";
//    }

}
