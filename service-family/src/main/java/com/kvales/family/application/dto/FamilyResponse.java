package com.kvales.family.application.dto;

import com.kvales.family.domain.model.Family;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FamilyResponse(
        String name,
        String email,
        String phone,
        LocalDate birthDate
) {

    public static FamilyResponse from(Family family) {
        return new FamilyResponse(
                family.getName(),
                family.getEmail(),
                family.getPhone(),
                family.getBirthDate()

        );
    }
}
