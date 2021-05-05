package com.example.musicmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.musicmanagement.domain.SongDomain;

public interface  SongRepo extends JpaRepository<SongDomain, Long> {
	

}
