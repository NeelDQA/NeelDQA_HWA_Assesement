package com.example.musicmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Song{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "You must enter a song name")
	private String songName;
	@NotNull(message = "You must enter an artist name")
	private String artistName;
	private String labelName;
	private String songKey;
	private String genre;
	private Long releaseYear;
	
	public Song() {}
	
	public Song(Long id, String songName, String artistName, String labelName, String songKey, String genre,
			Long releaseYear) {
		super();
		this.id = id;
		this.songName = songName;
		this.artistName = artistName;
		this.labelName = labelName;
		this.songKey = songKey;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}
	
	public Song(@NotNull(message = "You must enter a song name") String songName,
			@NotNull(message = "You must enter an artist name") String artistName, String labelName, String songKey,
			String genre, Long releaseYear) {
		super();
		this.songName = songName;
		this.artistName = artistName;
		this.labelName = labelName;
		this.songKey = songKey;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getSongKey() {
		return songKey;
	}
	public void setSongKey(String songKey) {
		this.songKey = songKey;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Long getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Long releaseYear) {
		this.releaseYear = releaseYear;
	}




	
	
	

}
