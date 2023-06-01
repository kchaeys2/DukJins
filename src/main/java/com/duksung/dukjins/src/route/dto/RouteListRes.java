package com.duksung.dukjins.src.route.dto;

import lombok.Getter;

@Getter
public class RouteListRes {
    private Long id;
    private String routeName;
    public RouteListRes(Long id, String routeName) {
        this.id = id;
        this.routeName = routeName;
    }
}
