package com.kvales.family.domain.repository;

import com.kvales.family.domain.model.Family;

import java.util.List;

public interface FamilyRepository {

    Family save(Family family);

    boolean existsByEmail(String email);

    List<Family> findAll();

}
