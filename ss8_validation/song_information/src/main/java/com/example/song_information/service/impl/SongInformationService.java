package com.example.song_information.service.impl;

import com.example.song_information.DTO.SongDTO;
import com.example.song_information.model.Song;
import com.example.song_information.repository.ISongInformationRepository;
import com.example.song_information.service.ISongInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

@Service
public class SongInformationService implements ISongInformationService {
    @Autowired
    private ISongInformationRepository songInformationRepository;
    @Override
    public List<Song> findAll() {
        return songInformationRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songInformationRepository.save(song);

    }

    @Override
    public void edit(Song song) {
        songInformationRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return songInformationRepository.findById(id).get();
    }
}
