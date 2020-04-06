package com.movie.repository;

import com.movie.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {

    private List<Movie> movieList = new ArrayList<>();

    public Optional<Movie> findById(Long id) {
        return movieList.stream().filter(movie -> movie.getId() == id).findFirst();
    }

    public List<Movie> findAll() {
        return movieList;
    }

    public Movie save(Movie movie) {
        movieList.add(movie);
        return movie;
    }

    public void deleteById(Long id) {
        if (findById(id).isPresent()) {
            movieList.remove(findById(id).get());
        }
    }
}
