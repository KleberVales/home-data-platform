package com.kvales.family.domain.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Family {


    private Long id;
    private String name;
    private String email;
    private String phone;
    private Relationship relationship;
    private LocalDate birthDate;


    public Family(String name, String email, String phone, Relationship relationship, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.relationship = relationship;
        this.birthDate = birthDate;
    }
}
