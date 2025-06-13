package com.reelgraph.client;

import com.reelgraph.dto.Review;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ReviewClient {
    private final WebClient client;

    public ReviewClient(@Value("${review.service.url}") String baseUrl){
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Flux<Review> reviews(Integer movieId){
        return this.client.get()
                .uri("/{id}", movieId)  // ✅ fix: URI template should be quoted properly
                .retrieve()
                .bodyToFlux(Review.class);
    }
}
