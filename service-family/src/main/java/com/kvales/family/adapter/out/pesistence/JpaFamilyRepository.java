package com.kvales.family.adapter.out.pesistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFamilyRepository extends JpaRepository<FamilyEntity, Long> {

    boolean existsByEmail(String email);

}
