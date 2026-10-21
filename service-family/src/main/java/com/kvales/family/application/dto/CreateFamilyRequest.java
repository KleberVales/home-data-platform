package com.kvales.family.application.dto;

import com.kvales.family.domain.model.Relationship;

import java.time.LocalDate;

public record CreateFamilyRequest (
        String name,
        String email,
        String phone,
        Relationship relationship,
        LocalDate birthDate
){
}
