package com.duksung.dukjins.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Object_id")
    private Long objectId;
    @Column(nullable = false)
    private Long routeId;
    @Column(nullable = false)
    private Float pointX;
    @Column(nullable = false)
    private Float pointY;

}
