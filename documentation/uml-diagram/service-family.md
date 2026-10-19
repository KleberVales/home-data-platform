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



