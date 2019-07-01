package com.stackroute.neo4jdemo.service;

import com.stackroute.neo4jdemo.domain.Movie;
import com.stackroute.neo4jdemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImplementation implements MovieService{

    @Autowired
    MovieRepository movieRepository;

    public MovieServiceImplementation(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Collection<Movie> getAll() {
        return movieRepository.getAllMovies();
    }

    @Override
    public Movie saveMovie(Long movieId,String movieTitle,String movieDirector) {
        Movie savedMovie=null;
        savedMovie=movieRepository.createNode(movieId,movieTitle,movieDirector);
        System.out.println(savedMovie);
        return savedMovie;

    }

    @Override
    public Movie updateMovie(Movie movie,Long movieId) {
        return movieRepository.updateNode(movieId,movie.getTitle(),movie.getDirector());
    }

    @Override
    public Movie getByName(String name) {
        return movieRepository.getNode(name);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

}
