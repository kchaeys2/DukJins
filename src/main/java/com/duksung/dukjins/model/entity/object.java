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
public class object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int objectIdx;
    private int routeIdx;
    private float pointX;
    private float pointY;
}
