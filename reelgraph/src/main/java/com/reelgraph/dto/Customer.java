package com.reelgraph.dto;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Integer id;
    private String name;
    private Genre genre;
    private List<Integer> watchList;
}
