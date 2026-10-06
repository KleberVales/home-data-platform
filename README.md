# home-data-platform

```text
                    ┌─────────────────────┐
                    │     React Frontend   │
                    │ Dashboard / Charts   │
                    └──────────┬──────────┘
                               │ HTTPS
                               ▼
                    ┌─────────────────────┐
                    │    Spring Boot API   │
                    │       Java 21        │
                    └──────────┬──────────┘
                               │
              ┌────────────────┼────────────────┐
              ▼                ▼                ▼
       ┌────────────┐   ┌────────────┐   ┌────────────┐
       │ PostgreSQL │   │   AWS S3   │   │   AWS IoT  │
       │ Dados      │   │ Imagens    │   │  Sensores  │
       └────────────┘   └────────────┘   └──────┬─────┘
                                                │
                             ┌──────────────────┼─────────────┐
                             ▼                  ▼             ▼
                         Temperatura        Umidade        Outros
                           Sensor             Sensor       dispositivos
```
