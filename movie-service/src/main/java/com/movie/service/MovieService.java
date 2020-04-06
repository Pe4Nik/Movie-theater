package com.movie.service;

import com.movie.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {

    Movie create(Movie newMovie);

    Movie read(Long id);

    Movie update(Long id, Movie newMovie);

    void delete(Long id);

    List<Movie> getAll();
}
