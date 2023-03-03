package com.autry.spring.InterfacesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autry.spring.Interfaces.MovieInterface;
import com.autry.spring.dao.movieRepo;
import com.autry.spring.models.Actor;
import com.autry.spring.models.Movie;

@Service
public class MovieInterfaceImp implements MovieInterface{
	
	@Autowired
	movieRepo mv_repo;

	@Override
	public Movie saveMovie(Movie m) {
		return mv_repo.save(m);
	}

	@Override
	public List<Movie> getMovies() {
		return mv_repo.findAll();
	}

	@Override
	public Movie updateMovie(Movie new_mv) {
		
		Movie m = mv_repo.findById(new_mv.getMv_id()).get();
		
		m.setMvTitle(new_mv.getMvTitle());
		m.setMv_descrip(new_mv.getMv_descrip());
		m.setMv_imdbRate(new_mv.getMv_imdbRate());
		m.setMv_pub_date(m.getMv_pub_date());
		m.setMv_duration(new_mv.getMv_duration());
		
		return m;
	}

	@Override
	public void deleteMovie(long id) {
		mv_repo.deleteById(id);
	}

	@Override
	public Movie getMovie(long id) {
		return mv_repo.findById(id).get();
	}

	@Override
	public Movie searchMovieByTitle(String title) {
		return mv_repo.findBymvTitleEquals(title);
	}

}
