package com.example.musicmanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.musicmanagement.domain.Song;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema.sql", "classpath:data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SongControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Song song = new Song("Glue", "Bicep", "NinjaTune", "Em", "Breakbeat", 2017L);

		String songAsJSON = this.mapper.writeValueAsString(song);

		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(songAsJSON);

		Song savedSong = new Song(3L, "Glue", "Bicep", "NinjaTune", "Em", "Breakbeat", 2017L);

		String savedSongAsJSON = this.mapper.writeValueAsString(savedSong);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedSongAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void testReadAll() throws Exception {

		RequestBuilder mockRequest = get("/getAll").contentType(MediaType.APPLICATION_JSON);

		Song expSong1 = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		Song expSong2 = new Song(2L, "Dust", "Brame & Hamo", "Feel My Bicep", "Fm", "House", 2019L);

		List<Song> arraySong = new ArrayList<Song>();

		arraySong.add(expSong1);

		arraySong.add(expSong2);

		String expSongAsJSON = this.mapper.writeValueAsString(arraySong);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(expSongAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void testReadById() throws Exception {

		final Long id = 1L;

		RequestBuilder mockRequest = get("/getOne/{id}", id).contentType(MediaType.APPLICATION_JSON);

		Song expSong = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		String expSongAsJSON = this.mapper.writeValueAsString(expSong);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(expSongAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void testReadBySongName() throws Exception {

		final String songName = "Teenage Birdsong";

//		String songNameAsJSON = this.mapper.writeValueAsString(songName);

		RequestBuilder mockRequest = get("/getBySongName/" + songName);

		Song expSong = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		String expSongAsJSON = this.mapper.writeValueAsString(expSong);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(expSongAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void testReadByArtistName() throws Exception {

		final String artistName = "Four Tet";

		RequestBuilder mockRequest = get("/getByArtistName/" + artistName);

		Song expSong1 = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		List<Song> arraySong = new ArrayList<Song>();

		arraySong.add(expSong1);

		String expSongAsJSON = this.mapper.writeValueAsString(arraySong);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(expSongAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}

	@Test
	void testReadByGenre() throws Exception {

		final String genre = "House";

		RequestBuilder mockRequest = get("/getByGenre/" + genre);

		Song expSong1 = new Song(1L, "Teenage Birdsong", "Four Tet", "Text Records", "Am", "House", 2019L);

		Song expSong2 = new Song(2L, "Dust", "Brame & Hamo", "Feel My Bicep", "Fm", "House", 2019L);

		List<Song> arraySong = new ArrayList<Song>();

		arraySong.add(expSong1);

		arraySong.add(expSong2);

		String expSongAsJSON = this.mapper.writeValueAsString(arraySong);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchBody = content().json(expSongAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void testUpdate() throws Exception {

		final Long id = 1L;

		Song song = new Song("Baby", "Four Tet", "Text Records", "Cm", "House", 2019L);

		String songAsJSON = this.mapper.writeValueAsString(song);

		RequestBuilder mockRequest = put("/update/" + id).contentType(MediaType.APPLICATION_JSON).content(songAsJSON);

		Song updatedSong = new Song(1L, "Baby", "Four Tet", "Text Records", "Cm", "House", 2019L);

		String updatedSongAsJSON = this.mapper.writeValueAsString(updatedSong);

		ResultMatcher matchStatus = status().isNoContent();

		ResultMatcher matchBody = content().json(updatedSongAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}
	
	@Test
	void testRemove() throws Exception {
		
		final Long id = 1L;
		
		RequestBuilder mockRequest = delete("/remove/"+id);
		
		ResultMatcher matchStatus = status().isNoContent();
		
		this.mockMVC.perform(mockRequest).andExpect(matchStatus);
		
	}
	
	
	
	
}
