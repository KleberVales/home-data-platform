package com.kvales.family.application.dto;

import com.kvales.family.domain.model.Family;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FamilyResponse(
        Long id,
        String name,
        String email,
        String phone,
        LocalDate birthDate,
        LocalDateTime createdAt
) {

    public static FamilyResponse from(Family family) {
        return new FamilyResponse(
                family.getId(),
                family.getName(),
                family.getEmail(),
                family.getPhone(),
                family.getBirthDate(),
                family.getCreateAt()

        );
    }
}
