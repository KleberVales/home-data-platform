package com.kvales.family.application.usecase;

import com.kvales.family.application.dto.CreateFamilyRequest;
import com.kvales.family.application.dto.FamilyResponse;
import com.kvales.family.domain.exception.FamilyAlreadyExistsException;
import com.kvales.family.domain.model.Family;
import com.kvales.family.domain.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateFamilyUseCase {

    private final FamilyRepository familyRepository;

    public FamilyResponse execute(CreateFamilyRequest request) {

        if (familyRepository.existsByEmail(request.email())) {
            throw new FamilyAlreadyExistsException(
                    "email",
                    request.email()
            );
        }

        Family family = new Family(
                request.name(),
                request.email(),
                request.phone(),
                request.relationship(),
                request.birthDate()
        );

        Family savedCustomer = familyRepository.save(family);

        return FamilyResponse.from(savedCustomer);
    }

    public List<FamilyResponse> getAll(){

        return familyRepository.findAll().stream().map(family -> new FamilyResponse(
                family.getName(),
                family.getEmail(),
                family.getPhone(),
                family.getBirthDate()
        )
        )
                .toList();
    }

}
