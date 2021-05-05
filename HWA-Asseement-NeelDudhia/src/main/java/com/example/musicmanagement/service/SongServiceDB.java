package com.example.musicmanagement.service;

import java.util.List;
import java.util.Optional;

import com.example.musicmanagement.domain.Song;
import com.example.musicmanagement.repo.SongRepo;

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

	public Song getById(Long id) {
		Optional<Song> optionalSong = this.repo.findById(id);
		return optionalSong.get();
	}

	// UPDATE

	public Song update(Long id, Song song) {
		Optional<Song> existingOptional = this.repo.findById(id);
		Song existing = existingOptional.get();

		existing.setSongName(song.getSongName());
		existing.setArtistName(song.getArtistName());
		existing.setLabelName(song.getLabelName());
		existing.setSongKey(song.getSongKey());
		existing.setReleaseYear(song.getReleaseYear());
		existing.setGenre(song.getGenre());

		return this.repo.saveAndFlush(existing);

	}

	// DELETE

	public boolean remove(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;

	}

	// READ BY ARTIST NAME

	public Song getSongByArtistName(String artistName) {
		return this.repo.findByartistName(artistName);
	}

	// READ BY SONG NAME

	public Song getSongBySongName(String songName) {
		return this.repo.findBysongName(songName);
		
	}
	
	//READ BY GENRE
	
	public Song getSongByGenre(String genre) {
		return this.repo.findBygenre(genre);
		
	}
	

}
