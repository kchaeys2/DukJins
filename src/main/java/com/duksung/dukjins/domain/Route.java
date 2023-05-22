package com.duksung.dukjins.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private Long memberId;
    private String routeName;
    private String startPoint;
    private String endPoint;
    @Column(length = 1)
    @ColumnDefault("0")
    private int mark;
    @Column(length = 1)
    @ColumnDefault("0")
    private int good;
    @Enumerated(EnumType.STRING)
    private RouteStatus status;
    private LocalDateTime createAt;
    //생성자
    public static Route createRoute(Long memberId,String routeName,
                                    String startPoint,String endPoint,RouteStatus status,
                                    int mark,int good){
        Route route = new Route();
        route.memberId = memberId;
        route.startPoint = startPoint;
        route.endPoint = endPoint;
        route.createAt = LocalDateTime.now();
        route.mark = mark;
        route.good = good;
        if(status != null){
            route.status = status;
        }else{
            route.status = RouteStatus.ACTIVE;
        }
        if(routeName != null){
            route.routeName = routeName;
        }else{
            route.routeName = endPoint;
        }
        return route;
    }
    //즐겨찾기 취소
    public void markCancel(){
        mark = 0;
    }
}
