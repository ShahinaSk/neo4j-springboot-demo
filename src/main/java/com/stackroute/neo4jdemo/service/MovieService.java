package com.stackroute.neo4jdemo.service;

import com.stackroute.neo4jdemo.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface MovieService {
    Collection<Movie> getAll();

    Movie saveMovie(Long movieId,String movieTitle,String movieDirector);

    Movie updateMovie(Movie movie,Long movieId);

    Movie getByName(String name);

    void deleteMovie(Long id);

}
