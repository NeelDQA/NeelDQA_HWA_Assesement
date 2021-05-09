package com.example.musicmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.musicmanagement.domain.Song;
@Repository
public interface SongRepo extends JpaRepository<Song, Long> {

	Song findBysongName(String songName);

	List<Song> findByartistName(String artistName);

	List<Song>findBygenre(String genre);

}
