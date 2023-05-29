package com.example.song_information.repository;

import com.example.song_information.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongInformationRepository extends JpaRepository<Song,Integer> {
}
