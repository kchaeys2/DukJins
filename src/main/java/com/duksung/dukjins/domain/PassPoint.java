package com.duksung.dukjins.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PassPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passPointId;
    @Column(nullable = false)
    private Float pointX;
    @Column(nullable = false)
    private Float pointY;
    @Column(nullable = false)
    private Long routeId;
}
