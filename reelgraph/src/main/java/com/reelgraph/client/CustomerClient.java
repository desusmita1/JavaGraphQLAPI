package com.reelgraph.client;

import com.reelgraph.dto.Customer;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CustomerClient {

    private final WebClient client;

    public CustomerClient(@Value("${customer.service.url}") String baseUrl){
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Mono<Customer> getCustomer(Integer id){
        return this.client.get()
                .uri("{id}", id)
                .retrieve()
                .bodyToMono(Customer.class);
    }
}
