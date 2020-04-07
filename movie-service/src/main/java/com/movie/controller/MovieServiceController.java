package com.movie.controller;

import com.movie.domain.Movie;
import com.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieServiceController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @PostMapping("/movie")
    public Movie newMovie(@RequestBody Movie newMovie) {
        return movieService.create(newMovie);
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.read(id);
    }

    @PutMapping("/movie/{id}")
    public Movie replaceMovie(@PathVariable Long id, @RequestBody Movie newMovie) {
        return movieService.update(id, newMovie);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
    }
}
