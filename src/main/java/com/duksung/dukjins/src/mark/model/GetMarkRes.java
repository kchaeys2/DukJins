package com.duksung.dukjins.src.mark.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMarkRes {
    private int routeIdx;
    private String routeName;
    private float endX;
    private float endY;

}
