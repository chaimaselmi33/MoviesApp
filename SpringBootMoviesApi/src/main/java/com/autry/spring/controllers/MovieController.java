package com.autry.spring.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autry.spring.Interfaces.MovieInterface;
import com.autry.spring.dao.movieRepo;
import com.autry.spring.models.Movie;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieInterface mv_interf;
	
	//Pagination tuto
	@Autowired
	movieRepo movieRepo;
	
	
	@GetMapping("/MoviePaging")
	Map<String, Object> getPageableMovies(@RequestParam(defaultValue = "6") int size, @RequestParam(defaultValue = "0") int page)
	{
		System.out.println("page :" + page);
		
		List<Movie> movies = new ArrayList<Movie>();
		//PageRequest implements Pageable interface 
		Pageable paging = PageRequest.of(page, size);
		
		Page<Movie> pageMv;
		
		pageMv = movieRepo.findAll(paging);
		
		movies = pageMv.getContent();
		
		Map<String, Object> res = new HashMap<>();
		
		res.put("movies", movies);
		res.put("total movies", pageMv.getNumberOfElements());
		res.put("totalPages", pageMv.getTotalPages());
		res.put("current page", pageMv.getNumber());
		
		return res;
	
	}
	
	@GetMapping("/get-movies")
	List<Movie> getMovies(){
		return mv_interf.getMovies();
	}
	
	@GetMapping("/get-moviesBy-cat/{cat}")
	List<Movie> getMoviesByCat(@PathVariable String cat){
		
		List<Movie> matchedMovies = mv_interf.getMovies().stream().filter(m -> m.getCategory().getCat_name().equals(cat)).toList();
		return matchedMovies;
	}
	
	
	@GetMapping("/search-by-title")
	Map<String, Object> searchMoviesByTitle(@RequestParam String title, @RequestParam(defaultValue = "0") int page){
		
		int size = 5;
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Movie> pageMv= movieRepo.findByMvTitleContaining(title, pageable);
		
		Map<String, Object> res = new HashMap<>();
		
		List<Movie> matchedMovies = pageMv.getContent();
		
		res.put("movies", matchedMovies);
		res.put("current page", pageMv.getNumber());
		res.put("totalPages", pageMv.getTotalPages());
		
		return res;
		
	}
	
	@PostMapping("/add-movie")
	Movie saveMovie(@RequestBody Movie m) {
		return mv_interf.saveMovie(m);
	}
	
	@GetMapping("/get-movie/{id}")
	Movie getMovie(@PathVariable long id) {
		return mv_interf.getMovie(id);
	}
	
	@PutMapping("/update-movie")
	Movie updateMovie(@RequestBody Movie m) {
		return mv_interf.updateMovie(m);
	}
	
	@DeleteMapping("/delete-movie/{id}")
	void deleteMovie(@PathVariable long id) {
		mv_interf.deleteMovie(id);
	}
	
}
