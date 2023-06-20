package com.example.first.controller;

import com.example.first.model.LoaiTin;
import com.example.first.model.Tin;
import com.example.first.service.ILoaiTinService;
import com.example.first.service.ITinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TinController {
    @Autowired
    private ILoaiTinService iLoaiTinService;
    @Autowired
    private ITinService iTinService;

    @GetMapping("/")
    public String showList(Model model){
        List<Tin> tinList = iTinService.findAll();
        List<LoaiTin> loaiTinList = iLoaiTinService.findAll();

        model.addAttribute("loaiTinList",loaiTinList);
        model.addAttribute("tinList",tinList);


        return "list";
    }


    @GetMapping("/create")
    public String createView(Model model){
        List<LoaiTin> loaiTinList = iLoaiTinService.findAll();

        model.addAttribute("loaiTinList",loaiTinList);
        model.addAttribute("tin",new Tin());



        return "create";
    }


    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("tin")Tin tin, BindingResult bindingResult, Model model){
if (bindingResult.hasErrors()){
            List<LoaiTin> loaiTinList = iLoaiTinService.findAll();
            model.addAttribute("loaiTinList",loaiTinList);
            return "create";
        }

        iTinService.save(tin);



        return "redirect:/";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("id")Integer id){
        iTinService.delete(id);

        return "redirect:/";
    }



    @GetMapping("/search")
    public String search(@RequestParam("loaiTinId")Integer loaiTinId, @RequestParam("tieuDe")String tieuDe, Model model){
        List<Tin> tinList = iTinService.search('%' + tieuDe + '%',loaiTinId);
        List<LoaiTin> loaiTinList = iLoaiTinService.findAll();

        model.addAttribute("loaiTinList",loaiTinList);
        model.addAttribute("tinList",tinList);

        return "list";
    }



}
