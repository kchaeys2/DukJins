package com.duksung.dukjins.src.route.model.post;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostRouteReq {
    @NonNull
    private int userIdx;
    private String routeName;
    @NonNull
    private boolean mark;
    @NonNull
    private boolean good;
    @NonNull
    private int startX;
    @NonNull
    private int startY;
    @NonNull
    private int endX;
    @NonNull
    private int endY;
    private Integer passPoint;
    // 다 필요할때
    public PostRouteReq(int userIdx,String routeName,boolean mark,boolean good,
                        int startX,int startY,int endX,int endY,int passPoint){
        this.userIdx = userIdx;
        this.routeName = routeName;
        this.mark = mark;
        this.good = good;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.passPoint = passPoint;
    }
    //경유지만 있고 이름은 없을 경우
    public PostRouteReq(int userIdx,boolean mark,boolean good,
                        int startX,int startY,int endX,int endY,int passPoint){
        this.userIdx = userIdx;
        this.mark = mark;
        this.good = good;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.passPoint = passPoint;
    }
    //경유지 없고 이름 있을 떄
    public PostRouteReq(int userIdx,String routeName,boolean mark,boolean good,
                        int startX,int startY,int endX,int endY){
        this.userIdx = userIdx;
        this.routeName = routeName;
        this.mark = mark;
        this.good = good;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}
