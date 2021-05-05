package com.example.musicmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SongDomain {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String songName;
	private String artistName;
	private String labelName;
	private String songKey;
	private String genre;
	private Long releaseYear;
	
	public SongDomain() {}
	
	public SongDomain(Long id, String songName, String artistName, String labelName, String songKey, String genre,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistName == null) ? 0 : artistName.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((labelName == null) ? 0 : labelName.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + ((songKey == null) ? 0 : songKey.hashCode());
		result = prime * result + ((songName == null) ? 0 : songName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SongDomain other = (SongDomain) obj;
		if (artistName == null) {
			if (other.artistName != null)
				return false;
		} else if (!artistName.equals(other.artistName))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (labelName == null) {
			if (other.labelName != null)
				return false;
		} else if (!labelName.equals(other.labelName))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (songKey == null) {
			if (other.songKey != null)
				return false;
		} else if (!songKey.equals(other.songKey))
			return false;
		if (songName == null) {
			if (other.songName != null)
				return false;
		} else if (!songName.equals(other.songName))
			return false;
		return true;
	}
	
	
	

	
	
	

}
