package com.example.musicmanagement.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicmanagement.domain.Song;
import com.example.musicmanagement.service.SongServiceDB;

@RestController
public class SongController {

	private SongServiceDB service;

	public SongController(SongServiceDB service) {
		this.service = service;
	}

	// CREATE

	@PostMapping("/create")
	public ResponseEntity<Song> createSong(@RequestBody Song song) {
		return new ResponseEntity<Song>(this.service.create(song), HttpStatus.CREATED);
	}

	// READ

	@GetMapping("/getAll")
	public ResponseEntity<List<Song>> getSongs() {
		return ResponseEntity.ok(this.service.getAll());
	}

	// READ SINGLE

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Song> getSongById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getById(id));
	}

	// READ BY SONG NAME

	@GetMapping("/getBySongName/{songName}")
	public ResponseEntity<Song> getSongBySongName(@PathVariable("songName") String songName) {
		return ResponseEntity.ok(this.service.getSongBySongName(songName));

	}
	
	//READ BY ARTIST NAME
	
	@GetMapping("/getByArtistName/{artistName}")
	public ResponseEntity<List<Song>> getSongByArtistName(@PathVariable("artistName") String artistName){
		return ResponseEntity.ok(this.service.getSongByArtistName(artistName));
	}
	
	//READ BY GENRE
	
	@GetMapping("/getByGenre/{genre}")
	public ResponseEntity<List<Song>> getSongByGenre(@PathVariable("genre") String genre){
		return ResponseEntity.ok(this.service.getSongByGenre(genre));
	}
	
	// UPDATE
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Song> updateSongById(@RequestBody Song song, @PathVariable Long id){
		return new ResponseEntity<Song>(this.service.update(id, song),HttpStatus.NO_CONTENT);
	}
	
	//DELETE
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Song> removeSong(@PathVariable Long id){
		this.service.remove(id);
		return new ResponseEntity<Song>(HttpStatus.NO_CONTENT);
	}
	
	
	
	

}
