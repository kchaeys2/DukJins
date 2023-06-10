package com.duksung.dukjins.src.mark.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarkReq {
    private Long member;
    private String endPoint;
    private String routeName;
}
