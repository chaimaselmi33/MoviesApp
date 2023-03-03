package com.autry.spring.Interfaces;

import java.util.List;

import com.autry.spring.models.Actor;
import com.autry.spring.models.Movie;

public interface MovieInterface {

	Movie saveMovie( Movie m );
	
	List<Movie> getMovies();
	
	Movie updateMovie(Movie m);
	
	void deleteMovie(long id);
	
	Movie getMovie(long id);
	
	Movie searchMovieByTitle(String title);
	
}
