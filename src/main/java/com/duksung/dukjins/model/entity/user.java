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
public class user {

    public user(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIdx;
    private String singIn;
    private String nickname;
    private String email;
    private String pw;
}
