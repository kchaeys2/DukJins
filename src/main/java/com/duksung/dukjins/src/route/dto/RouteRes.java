package com.duksung.dukjins.src.route.dto;

import com.duksung.dukjins.domain.Point;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class RouteRes {
    private Long id;
    private String startPoint;
    private String endPoint;
    private String routeName;
    private List<Point> passPoints = new ArrayList<>();
    private List<Point> objectPoints = new ArrayList<>();
    public RouteRes(Long id,String startPoint,String endPoint,String routeName){
        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.routeName = routeName;
    }
    public void addPassPoint(Point passPoint){
        passPoints.add(passPoint);
    }
    public void addObjectPoint(Point objectPoint){
        objectPoints.add(objectPoint);
    }
}
