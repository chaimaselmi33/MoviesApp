package com.autry.spring.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long cat_id;
	
	String cat_name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="category")
	List<Movie> movies;

	public Category() {
		super();
	}

	public Category(Long cat_id, String cat_name, List<Movie> movies) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		//this.movies = movies;
	}

	public Long getCat_id() {
		return cat_id;
	}

	public void setCat_id(Long cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
/*
	public List<Movie> getMovie() {
		return movies;
	}

	public void setMovie(List<Movie> movies) {
		this.movies = movies;
	}*/

}
