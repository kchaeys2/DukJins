package com.duksung.dukjins.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class passPoint {
    public passPoint(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ppIdx;
    private int routeIdx;
    private float pointX;
    private float pointY;
}
