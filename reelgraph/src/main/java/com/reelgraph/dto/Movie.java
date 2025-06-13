package com.reelgraph.dto;

import lombok.Data;

@Data
public class Movie {
    private Integer id;
    private String title;
    private Integer releaseYear;
    private Integer rating;
    private Genre genre;
}
