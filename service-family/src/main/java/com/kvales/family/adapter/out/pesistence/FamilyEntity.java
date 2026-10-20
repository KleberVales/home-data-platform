package com.kvales.family.adapter.out.pesistence;

import com.kvales.family.domain.model.Family;
import com.kvales.family.domain.model.Relationship;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class FamilyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String phone;

    @Column
    private Relationship relationship;

    @Column
    private LocalDate birthDate;


    public FamilyEntity(String name, String email, String phone, Relationship relationship,  LocalDate birthDate ) {
        this.birthDate = birthDate;
        this.relationship = relationship;
        this.phone = phone;
        this.email = email;
        this.name = name;
    }

    public FamilyEntity(){}



}
