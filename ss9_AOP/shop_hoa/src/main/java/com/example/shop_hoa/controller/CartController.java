package com.example.shop_hoa.controller;

import com.example.shop_hoa.model.Flower;
import com.example.shop_hoa.service.ICartService;
import com.example.shop_hoa.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private IFlowerService iFlowerService;

    @Autowired
    private ICartService iCartService;



    @GetMapping("/cart")
    public String carts(@SessionAttribute("cart") Map<Flower,Integer> list , Model model){
        model.addAttribute("cart",list);
        double total = iCartService.getTotal(list);
        model.addAttribute("total", total);
        return "shopping-cart";
    }
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes,
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

        return "redirect:/cart";
    }
    @GetMapping("/remove/{id}")
    public String removeToCart(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes,
                               @ModelAttribute("cart") Map<Flower, Integer> flowerList) {
        Flower flower = iFlowerService.findById(id);
        Integer quantity;
        if (!iCartService.checkExist(flower, flowerList)) {
            flowerList.put(flower, 1);
        } else {
            Map.Entry<Flower,Integer> m = iCartService.flowerIntegerEntry(flower,flowerList);

             quantity = m.getValue() - 1;
            flowerList.replace(m.getKey(),quantity);
            if (m.getValue()==0){
                flowerList.remove(m.getKey());
            }
        }

        return "redirect:/cart";
    }
}
