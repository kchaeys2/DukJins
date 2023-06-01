package com.duksung.dukjins.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routes_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private String routeName;
    private String startPoint;
    private String endPoint;
    @OneToMany(mappedBy = "routes")
    private List<PassPoint> passPoints = new ArrayList<>();
    @OneToMany(mappedBy = "routes")
    private List<Object> objects = new ArrayList<>();
    @Column(length = 1)
    @ColumnDefault("0")
    private int mark;
    @Column(length = 1)
    @ColumnDefault("0")
    private int good;
    @Enumerated(EnumType.STRING)
    private RouteStatus status;
    private LocalDateTime createAt;

    /**연관관계 메소드**/
    public void setMember(Member member) {
        this.member = member;
    }
    public void addPassPoint(PassPoint passPoint){
        passPoints.add(passPoint);
        passPoint.setRoute(this);
    }
    public void addObject(Object object){
        objects.add(object);
        object.setRoute(this);
    }

    /**생성자**/
    public static Route createRoute(Member member, String routeName, String startPoint, String endPoint, int mark, int good,RouteStatus status,
                                    List<Point> passPoints, List<Point> objectPoints){
        Route route = new Route();
        route.setMember(member);

        if(routeName != null){
            route.routeName = routeName;
        }else{
            route.routeName = endPoint;
        }

        route.startPoint = startPoint;
        route.endPoint = endPoint;
        route.mark = mark;
        route.good = good;

        if(status != null){
            route.status = status;
        }else{
            route.status = RouteStatus.ACTIVE;
        }

        route.createAt = LocalDateTime.now();

        if(passPoints.size() != 0){
            for (Point point:passPoints){
                PassPoint passPoint = new PassPoint();
                passPoint.setPoint(point);
                route.addPassPoint(passPoint);
            }
        }

        if(objectPoints != null){
            for (Point point:objectPoints){
                Object object = new Object();
                object.setPoint(point);
                route.addObject(object);
            }
        }

        return route;
    }
    /**setter**/
    public void setMark(int mark){
        this.mark = mark;
    }
    public void setRouteName(String routeName){
        this.routeName = routeName;
    }
}
