package com.example.musicmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.musicmanagement.domain.Song;
@Repository
public interface SongRepo extends JpaRepository<Song, Long> {

	Song findBysongName(String songName);

	Song findByartistName(String artistName);

	Song findBygenre(String genre);

}
