package com.kvales.family.adapter.in.web;

import com.kvales.family.application.dto.CreateFamilyRequest;
import com.kvales.family.application.dto.FamilyResponse;
import com.kvales.family.application.usecase.CreateFamilyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family")
@RequiredArgsConstructor
public class FamilyController {

    private final CreateFamilyUseCase createFamilyUseCase;

    @PostMapping
    public ResponseEntity<FamilyResponse> create(
            @RequestBody CreateFamilyRequest request
    ) {


        FamilyResponse response =
                createFamilyUseCase.execute(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<FamilyResponse>> getAll(){

        List<FamilyResponse> familyResponses = createFamilyUseCase.getAll();

        return ResponseEntity.ok(familyResponses);
    }

}
