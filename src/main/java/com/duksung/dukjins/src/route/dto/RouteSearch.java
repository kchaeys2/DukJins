package com.duksung.dukjins.src.route.dto;

import com.duksung.dukjins.domain.RouteStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RouteSearch {
    private Long memberId;
//    private RouteStatus status; 동적쿼리 공부후 적용
}
