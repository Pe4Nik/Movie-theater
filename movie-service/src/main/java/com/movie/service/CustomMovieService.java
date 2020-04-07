package com.movie.service;

import com.movie.domain.Movie;
import com.movie.exception.MovieNotFoundException;
import com.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomMovieService implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie create(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @Override
    public Movie read(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public Movie update(Long id, Movie newMovie) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setName(newMovie.getName());
                    movie.setDescription(newMovie.getDescription());
                    movie.setRating(newMovie.getRating());
                    return movieRepository.save(movie);
                })
                .orElseGet(() -> {
                    newMovie.setId(id);
                    return movieRepository.save(newMovie);
                });
    }

    @Override
    public void delete(Long id) {
        if (movieRepository.findById(id).isPresent()) {
            movieRepository.deleteById(id);
        } else {
            throw new MovieNotFoundException(id);
        }
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
