package com.reelgraph.dto;


import lombok.Data;

import java.util.List;

@Data
public class WatchListResponse {

    private Status status;
    private List<Integer> watchList;
}
