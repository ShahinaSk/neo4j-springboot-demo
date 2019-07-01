package com.stackroute.neo4jdemo.controller;


import com.stackroute.neo4jdemo.domain.Movie;
import com.stackroute.neo4jdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("movies")
    public Collection<Movie> getAll(){
        return movieService.getAll();
    }


    @PostMapping("save")
    public Movie saveMovie(@RequestBody Movie movie) {

        return movieService.saveMovie(movie.getId(), movie.getTitle(),movie.getDirector());
    }

    @PutMapping("update/{id}")
    public Movie updateMovie(@RequestBody Movie movie,@PathVariable Long movieId){

        return movieService.updateMovie(movie,movieId);
    }

    @GetMapping("{name}")
    public  Movie getMovie(@PathVariable String name){
        return movieService.getByName(name);
    }

    @DeleteMapping("delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "Deleted Movie";
    }

}
