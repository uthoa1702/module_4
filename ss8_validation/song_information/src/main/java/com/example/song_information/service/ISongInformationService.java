package com.example.song_information.service;

import com.example.song_information.DTO.SongDTO;
import com.example.song_information.model.Song;

import java.util.List;

public interface ISongInformationService {
    List<Song> findAll();
}
