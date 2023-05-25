package com.duksung.dukjins.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jdk.jfr.Enabled;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Enabled
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Point {
    private Float pointX;
    private Float pointY;
    public Point(Float pointX,Float pointY){
        this.pointX = pointX;
        this.pointY = pointY;
    }
}
