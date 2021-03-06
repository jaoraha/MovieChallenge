package com.MovieChallenge.MovieChallenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieChallenge.MovieChallenge.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findByCategory(String category);
	
	
}
