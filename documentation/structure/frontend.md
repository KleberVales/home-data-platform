frontend
├── index.html
├── vite.config.ts
└── src/
     ├── main.tsx
     ├── App.tsx
     ├── index.css
     ├── components/
     │   ├── FamilyForm.tsx      formulário de cadastro
     │   └── FamilyTable.tsx     tabela de membros
     ├── pages/
     │   └── FamilyPage.tsx      junta tudo, carrega e salva
     └── services/
          └── familyService.ts    GET e POST em /api/family