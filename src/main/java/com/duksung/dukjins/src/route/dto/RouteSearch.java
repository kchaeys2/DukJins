package com.duksung.dukjins.src.route.dto;

import lombok.Getter;

@Getter
public class RouteSearch {
    private String startPoint;
    private String endPoint;
    public RouteSearch(String startPoint,String endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
