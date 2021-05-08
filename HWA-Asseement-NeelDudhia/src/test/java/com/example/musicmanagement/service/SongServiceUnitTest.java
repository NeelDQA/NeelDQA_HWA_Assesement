package com.example.musicmanagement.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.example.musicmanagement.domain.Song;
import com.example.musicmanagement.repo.SongRepo;

@SpringBootTest
@Sql(scripts = { "classpath:schema.sql", "classpath:data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SongServiceUnitTest {

	@Autowired
	private SongServiceDB service;

	@MockBean
	private SongRepo repo;

	@Test
	void testCreate() {
		Song song = new Song("Glue", "Bicep", "NinjaTune", "Em", "Breakbeat", 2017L);

		Song savedSong = new Song(3L, "Glue", "Bicep", "NinjaTune", "Em", "Breakbeat", 2017L);

		Mockito.when(this.repo.saveAndFlush(song)).thenReturn(savedSong);

		assertThat(this.service.create(song)).isEqualTo(savedSong);

		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(song);
	}

	@Test
	void teadRead() {

		Song expSong1 = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		Song expSong2 = new Song(2L, "Dust", "Brame & Hamo", "Feel My Bicep", "Fm", "House", 2019L);

		List<Song> arraySong = new ArrayList<Song>();

		arraySong.add(expSong1);

		arraySong.add(expSong2);

		Mockito.when(this.repo.findAll()).thenReturn(arraySong);

		assertThat(this.service.getAll()).isEqualTo(arraySong);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	void testReadById() {

		Song song = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		final Long id = 1L;

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(song));

		assertThat(this.service.getById(id)).isEqualTo(song);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);

	}

	@Test
	void testUpdate() {
		final Long id = 1L;

		Song song = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		Song updatedSong = new Song(1L, "Baby", "Four Tet", "Text Records", "Cm", "House", 2019L);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(song));

		Mockito.when(this.repo.saveAndFlush(song)).thenReturn(updatedSong);

		assertThat(this.service.update(id, song)).isEqualTo(updatedSong);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);

		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(song);

	}

	@Test

	void TestRemove() {
		final Long id = 1L;
		final Long id2 = 3L;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		Mockito.when(this.repo.existsById(id2)).thenReturn(true);

		assertThat(this.service.remove(id)).isEqualTo(true);

		assertThat(this.service.remove(id2)).isEqualTo(false);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id2);

	}

	@Test
	void testReadByArtistName() {

		final String artistName = "Four Tet";

		Song expSong = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		List<Song> arraySong = new ArrayList<Song>();

		arraySong.add(expSong);

		Mockito.when(this.repo.findByartistName(artistName)).thenReturn(arraySong);

		assertThat(this.service.getSongByArtistName(artistName)).isEqualTo(arraySong);

		Mockito.verify(this.repo, Mockito.times(1)).findByartistName(artistName);

	}

	@Test
	void testReadBySongName() {

		final String songName = "Dust";

		Song expSong = new Song(2L, "Dust", "Brame & Hamo", "Feel My Bicep", "Fm", "House", 2019L);

		Mockito.when(this.repo.findBysongName(songName)).thenReturn(expSong);

		assertThat(this.service.getSongBySongName(songName)).isEqualTo(expSong);

		Mockito.verify(this.repo, Mockito.times(1)).findBysongName(songName);

	}

	@Test
	void testReadByGenre() {
		final String genre = "House";

		Song expSong1 = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		Song expSong2 = new Song(2L, "Dust", "Brame & Hamo", "Feel My Bicep", "Fm", "House", 2019L);

		List<Song> arraySong = new ArrayList<Song>();

		arraySong.add(expSong1);

		arraySong.add(expSong2);

		Mockito.when(this.repo.findBygenre(genre)).thenReturn(arraySong);

		assertThat(this.service.getSongByGenre(genre)).isEqualTo(arraySong);

		Mockito.verify(this.repo, Mockito.times(1)).findBygenre(genre);

	}

}
