package com.duksung.dukjins.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PassPoints")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PassPoint{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pass_point_id")
    private Long passPointId;
    @Embedded
    private Point point;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route routes;

    public void setRoute(Route route) {
        routes = route;
    }
    public void setPoint(Point point){
        this.point = point;
    }
}
