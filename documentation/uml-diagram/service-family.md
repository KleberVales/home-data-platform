# service-family: UML Class Diagram

```mermaid
classDiagram
    direction TB

    class FamilyMemberController {
        -FamilyMemberService familyMemberService
        +create(CreateFamilyMemberRequest) FamilyMemberResponse
        +getById(UUID id) FamilyMemberResponse
        +update(UUID id, UpdateFamilyMemberRequest) FamilyMemberResponse
        +delete(UUID id) void
    }
    class FamilyMemberService {
        <<interface>>
        +create(CreateFamilyMemberRequest) FamilyMemberResponse
        +getById(UUID id) FamilyMemberResponse
        +update(UUID id, UpdateFamilyMemberRequest) FamilyMemberResponse
        +delete(UUID id) void
    }

    class FamilyMemberServiceImpl {
        -FamilyMemberRepository repository
        -FamilyMemberMapper mapper
        +create(CreateFamilyMemberRequest) FamilyMemberResponse
        +getById(UUID id) FamilyMemberResponse
        +update(UUID id, UpdateFamilyMemberRequest) FamilyMemberResponse
        +delete(UUID id) void
    }
    class FamilyMemberRepository {
        <<interface>>
        +save(FamilyMember) FamilyMember
        +findById(UUID id) Optional~FamilyMember~
        +existsById(UUID id) boolean
        +deleteById(UUID id) void
    }

    class FamilyMemberMapper {
        +toEntity(CreateFamilyMemberRequest) FamilyMember
        +updateEntity(UpdateFamilyMemberRequest, FamilyMember) void
        +toResponse(FamilyMember) FamilyMemberResponse
    }

    class FamilyMember {
        <<entity>>
        -UUID id
        -String firstName
        -String lastName
        -LocalDate birthDate
        -Relationship relationship
        -String email
        -String phone
        -LocalDateTime createdAt
        -LocalDateTime updatedAt
    }





