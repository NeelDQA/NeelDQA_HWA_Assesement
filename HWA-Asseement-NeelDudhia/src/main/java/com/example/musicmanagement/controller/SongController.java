package com.example.musicmanagement.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicmanagement.domain.Song;
import com.example.musicmanagement.exceptions.SongNotFoundException;
import com.example.musicmanagement.service.SongServiceDB;

@RestController
@CrossOrigin
public class SongController {

	private SongServiceDB service;

	public SongController(SongServiceDB service) {
		this.service = service;
	}

	// CREATE

	@PostMapping("/create")
	public ResponseEntity<Song> createSong(@RequestBody Song songCreate) {
		return new ResponseEntity<Song>(this.service.create(songCreate), HttpStatus.CREATED);
	}

	// READ

	@GetMapping("/getAll")
	public ResponseEntity<List<Song>> getSongs() {
		return ResponseEntity.ok(this.service.getAll());
	}

	// READ SINGLE

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Song> getSongById(@PathVariable Long id) throws SongNotFoundException {
		return ResponseEntity.ok(this.service.getById(id));
	}

	

	// UPDATE
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Song> updateSongById(@RequestBody Song songUpdate, @PathVariable Long id) throws SongNotFoundException{
		return new ResponseEntity<Song>(this.service.update(id, songUpdate),HttpStatus.NO_CONTENT);
	}
	
	//DELETE
	@DeleteMapping("/remove/{id}")
	@CrossOrigin
	public ResponseEntity<Song> removeSong(@PathVariable Long id){
		this.service.remove(id);
		return new ResponseEntity<Song>(HttpStatus.NO_CONTENT);
	}
	
	
	
	

}
