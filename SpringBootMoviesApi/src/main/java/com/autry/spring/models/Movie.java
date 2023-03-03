package com.autry.spring.models;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long mv_id;
	String mvTitle;
	@Column(length=400)
	String mv_descrip;
	Double mv_imdbRate;
	LocalDate mv_pub_date;
	LocalTime mv_duration;
	
	@Lob @Column (length=16777215)
	byte[] movieImg;
	
	@Lob @Column (length=16777215)
	byte[] mv_poster;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	Category category;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="movie_actor", 
		joinColumns = { @JoinColumn(name = "fk_movie", referencedColumnName = "mv_id")}, 
		inverseJoinColumns = { @JoinColumn(name = "fk_actor", referencedColumnName = "ac_id")})
	@JsonManagedReference
	List<Actor> actors; 
	
	public Movie() {
		super();
	}

	public Movie(Long mv_id, String mvTitle, String mv_descrip, Double mv_imdbRate, LocalDate mv_pub_date,
			LocalTime mv_duration, byte[] movieImg, byte[] mv_poster, Category category, List<Actor> actors) {
		super();
		this.mv_id = mv_id;
		this.mvTitle = mvTitle;
		this.mv_descrip = mv_descrip;
		this.mv_imdbRate = mv_imdbRate;
		this.mv_pub_date = mv_pub_date;
		this.mv_duration = mv_duration;
		this.movieImg = movieImg;
		this.mv_poster = mv_poster;
		this.category = category;
		this.actors = actors;
	}

	public Long getMv_id() {
		return mv_id;
	}

	public void setMv_id(Long mv_id) {
		this.mv_id = mv_id;
	}

	public String getMvTitle() {
		return mvTitle;
	}

	public void setMvTitle(String mvTitle) {
		this.mvTitle = mvTitle;
	}

	public String getMv_descrip() {
		return mv_descrip;
	}

	public void setMv_descrip(String mv_descrip) {
		this.mv_descrip = mv_descrip;
	}

	public Double getMv_imdbRate() {
		return mv_imdbRate;
	}

	public void setMv_imdbRate(Double mv_imdbRate) {
		this.mv_imdbRate = mv_imdbRate;
	}

	public LocalDate getMv_pub_date() {
		return mv_pub_date;
	}

	public void setMv_pub_date(LocalDate mv_pub_date) {
		this.mv_pub_date = mv_pub_date;
	}

	public LocalTime getMv_duration() {
		return mv_duration;
	}

	public void setMv_duration(LocalTime mv_duration) {
		this.mv_duration = mv_duration;
	}

	public byte[] getMovieImg() {
		return movieImg;
	}

	public void setMovieImg(byte[] movieImg) {
		this.movieImg = movieImg;
	}

	public byte[] getMv_poster() {
		return mv_poster;
	}

	public void setMv_poster(byte[] mv_poster) {
		this.mv_poster = mv_poster;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
}
