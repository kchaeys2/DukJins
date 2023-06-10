package com.duksung.dukjins.src.mark.dto;

import lombok.Getter;

@Getter
public class MarkListRes {
    private String markName;
    private Long id;
    public MarkListRes(String markName,Long id){
        this.markName = markName;
        this.id = id;
    }
}
