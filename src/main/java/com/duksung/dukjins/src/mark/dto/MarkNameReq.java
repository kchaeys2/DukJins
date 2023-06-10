package com.duksung.dukjins.src.mark.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarkNameReq {
    private Long id;
    private String name;
    public MarkNameReq(Long id,String name){
        this.id = id;
        this.name = name;
    }
}
