package com.kvales.family.application.dto;

import java.time.LocalDate;

public record CreateFamilyRequest (
        String name,
        String cpf,
        String email,
        String phone,
        LocalDate birthDate
){
}
