package com.duksung.dukjins.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "objects")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Object_id")
    private Long objectId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "route_id")
    private Route routes;
    @Embedded
    private Point point;

    public void setRoute(Route route) {
        routes = route;
    }
    public void setPoint(Point point){
        this.point = point;
    }
    //연관관계
}
