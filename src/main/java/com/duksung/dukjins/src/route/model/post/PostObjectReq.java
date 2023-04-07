package com.duksung.dukjins.src.route.model.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostObjectReq {
    private int routeIdx;
    private int pointX;
    private int pointY;
    public PostObjectReq(int pointX,int pointY){
        this.pointX = pointX;
        this.pointY = pointY;
    }
}
