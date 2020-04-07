package com.movie.domain;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String name;
    private String description;
    private Double rating;
}
