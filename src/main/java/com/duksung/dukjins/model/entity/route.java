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
public class route {
    public route(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeIdx;
    private int userIdx;
    private String routeName;
    private String startPoint;
    private String destination;
    private char status;
}
