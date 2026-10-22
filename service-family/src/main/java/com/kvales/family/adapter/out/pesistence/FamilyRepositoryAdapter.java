package com.kvales.family.adapter.out.pesistence;

import com.kvales.family.domain.model.Family;
import com.kvales.family.domain.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FamilyRepositoryAdapter implements FamilyRepository {

    private final JpaFamilyRepository jpaFamilyRepository;


    @Override
    public Family save(Family family){

        FamilyEntity familyEntity = toEntity(family);

        FamilyEntity saved = jpaFamilyRepository.save(familyEntity);

        return toDomain(saved);

    }

    @Override
    public boolean existsByEmail(String email) {

        return jpaFamilyRepository.existsByEmail(email);
    }


    private FamilyEntity toEntity(Family family) {

        return new FamilyEntity(
                family.getName(),
                family.getEmail(),
                family.getPhone(),
                family.getRelationship(),
                family.getBirthDate()

        );
    }

    @Override
    public List<Family> findAll(){

        return jpaFamilyRepository.findAll().stream().map(FamilyEntity::toDomain).toList();

    }

    public Family toDomain(FamilyEntity familyEntity) {
        return new Family(
                familyEntity.getName(),
                familyEntity.getEmail(),
                familyEntity.getPhone(),
                familyEntity.getRelationship(),
                familyEntity.getBirthDate()
        );
    }
}
