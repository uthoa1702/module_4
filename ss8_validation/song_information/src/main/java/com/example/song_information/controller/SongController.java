package com.example.song_information.controller;

import com.example.song_information.DTO.SongDTO;
import com.example.song_information.model.Song;
import com.example.song_information.service.ISongInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
