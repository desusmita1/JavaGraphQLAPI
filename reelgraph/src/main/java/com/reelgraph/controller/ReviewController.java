package com.reelgraph.controller;

import com.reelgraph.client.ReviewClient;
import com.reelgraph.dto.Movie;
import com.reelgraph.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ReviewController {
    @Autowired
    private ReviewClient client;


    @SchemaMapping(typeName = "MovieDetails")
    public Flux<Review> reviews(Movie movie){
        return this.client.reviews(movie.getId());
    }

}
