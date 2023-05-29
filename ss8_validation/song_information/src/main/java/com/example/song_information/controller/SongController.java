package com.example.song_information.controller;

import com.example.song_information.DTO.SongDTO;
import com.example.song_information.model.Song;
import com.example.song_information.service.ISongInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongInformationService songInformationService;


    @GetMapping("/")
    public String home(Model model){
        List<Song> songList = songInformationService.findAll();
        model.addAttribute("songList", songList);
        return "list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute ("song") SongDTO songDTO){
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Song song = songInformationService.findById(id);
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song,songDTO);
        model.addAttribute("song",songDTO);
        return "edit";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute ("song") SongDTO songDTO, BindingResult bindingResult){
        new SongDTO().validate(songDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO,song);
        songInformationService.save(song);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute ("song") SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new SongDTO().validate(songDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return "/edit";
        }
        else {
        Song song = new Song();
        BeanUtils.copyProperties(songDTO,song);
        songInformationService.edit(song);
        redirectAttributes.addFlashAttribute("mess","UPDATED");
        return "redirect:/";
    }}
}
