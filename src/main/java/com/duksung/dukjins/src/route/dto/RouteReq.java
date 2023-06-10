package com.duksung.dukjins.src.route.dto;

import com.duksung.dukjins.domain.Point;
import com.duksung.dukjins.domain.RouteStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteReq {
    private Long memberId;
    private String startPoint;
    private String endPoint;
    private RouteStatus status;
    private int good;
    private List<Point> passPoints;
    private List<Point> objectPoints;

}
