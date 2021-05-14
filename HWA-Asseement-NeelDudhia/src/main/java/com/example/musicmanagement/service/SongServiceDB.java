package com.example.musicmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.musicmanagement.domain.Song;
import com.example.musicmanagement.exceptions.SongNotFoundException;
import com.example.musicmanagement.repo.SongRepo;
@Service
public class SongServiceDB {

	private SongRepo repo;

	public SongServiceDB(SongRepo repo) {
		this.repo = repo;
	}

	// CREATE

	public Song create(Song s) {
		return this.repo.saveAndFlush(s);

	}

	// READ ALL

	public List<Song> getAll() {
		return this.repo.findAll();

	}

	// READ BY ID

	public Song getById(Long id) throws SongNotFoundException {
		Optional<Song> optionalSong = this.repo.findById(id);
		if( optionalSong.isPresent()) {
			return optionalSong.get();}
		else {
			throw new SongNotFoundException();
		}
	}
		
	
	// UPDATE

	public Song update(Long id, Song song) throws SongNotFoundException{
		Optional<Song> existingOptional = this.repo.findById(id);
		if( existingOptional.isPresent()) {
		Song existing = existingOptional.get();
		existing.setSongName(song.getSongName());
		existing.setArtistName(song.getArtistName());
		existing.setLabelName(song.getLabelName());
		existing.setSongKey(song.getSongKey());
		existing.setReleaseYear(song.getReleaseYear());
		existing.setGenre(song.getGenre());

		return this.repo.saveAndFlush(existing);}
		else {
			throw new SongNotFoundException();
		}

		

	}

	// DELETE

	public boolean remove(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;

	}


	

}
