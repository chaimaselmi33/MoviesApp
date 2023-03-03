package com.autry.spring.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autry.spring.models.Movie;

@Repository
public interface movieRepo extends JpaRepository<Movie, Long>{

	Movie findBymvTitleEquals(String mv_title);
	
	Page<Movie>findByMvTitleContaining(String title, Pageable pageable);
	
	//List<Movie> findByMvTitleContaining(String title, Pageable pageable);
	
}
