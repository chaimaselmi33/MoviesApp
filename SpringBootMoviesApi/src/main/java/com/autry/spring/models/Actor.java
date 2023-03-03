package com.autry.spring.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ac_id;
	
	String ac_name;
	
	@Lob 
	byte[] ac_img;
	
	@ManyToMany(mappedBy="actors", fetch = FetchType.LAZY)
	@JsonBackReference
	List<Movie> movies;
	
	public Actor() {
		super();
	}

	public Actor(Long ac_id, String ac_name, byte[] ac_img, List<Movie> movies) {
		super();
		this.ac_id = ac_id;
		this.ac_name = ac_name;
		this.ac_img = ac_img;
		this.movies = movies;
	}

	public Long getAc_id() {
		return ac_id;
	}

	public void setAc_id(Long ac_id) {
		this.ac_id = ac_id;
	}

	public String getAc_name() {
		return ac_name;
	}

	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}

	public byte[] getAc_img() {
		return ac_img;
	}

	public void setAc_img(byte[] ac_img) {
		this.ac_img = ac_img;
	}
	
	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}	

}
