# Home data platform

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

## Components

- Temperature — temperature by room and period.
- Humidity — relative humidity.
- Camera — cameras, events, and possibly image/video storage.
- Energy — energy consumption.
- Presence — presence/movement.
- Air Quality — CO₂, particles, air quality.
- Weather — external data for comparison with internal data.
- Alerts — temperatures, humidity, presence, or other out-of-the-ordinary events.
- Analytics — averages, maximums, minimums, trends, and correlations.
- Dashboard — consolidated visualization in React.
