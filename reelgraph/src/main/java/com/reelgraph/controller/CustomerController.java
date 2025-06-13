package com.reelgraph.controller;

import com.reelgraph.client.CustomerClient;
import com.reelgraph.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Controller
public class CustomerController {

    @Autowired
    private CustomerClient client;

    @QueryMapping
    public Mono<Customer> userProfile(@Argument Integer id){
        return this.client.getCustomer(id);
    }


    @MutationMapping
    public Mono<Customer> updateCustomer(@Argument CustomerInput input){
        return this.client.updateCustomer(input);
    }

    @MutationMapping
    public Mono<WatchListResponse> addWatchList(@Argument WatchListInput input){
        return this.client.addToWatchList(input)
                .map(list-> WatchListResponse.create(Status.SUCCESS,list))
                .onErrorReturn(WatchListResponse.create(Status.FAILURE, Collections.emptyList()));
    }

}
