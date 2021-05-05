package com.example.musicmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.musicmanagement.domain.Song;

public interface  SongRepo extends JpaRepository<Song, Long> {
	
	Song findBysongName(String songName);
	Song findByartistName(String artistName);
	Song findBygenre(String genre);

}
