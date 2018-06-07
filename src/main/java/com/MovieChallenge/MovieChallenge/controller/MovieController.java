package com.MovieChallenge.MovieChallenge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.MovieChallenge.MovieChallenge.repository.MovieRepository;
import com.MovieChallenge.MovieChallenge.model.Movie;


@RestController
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/")
	public List<Movie> getAllMovies() {
	    return movieRepository.findAll();
	}
	
	@GetMapping("/findById")
	public Optional<Movie> getMovieById(@RequestParam("id") int id) {
		return movieRepository.findById(id);		
	}
	
	@GetMapping("/findRandom")
	public Optional<Movie> getRandomMovie() {
		Random rand = new Random();
		int id = rand.nextInt(10)+1;
		return movieRepository.findById(id);
	}
	
	@GetMapping("/findByCategory")
	public List<Movie> findByCategory1(@RequestParam("category") String category) {
		List<Movie> movieListCat = new ArrayList<>();
		movieListCat = movieRepository.findByCategory(category);
		return movieListCat; 		
	}


}
