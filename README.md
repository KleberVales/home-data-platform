# 🏠 Home Data Platform

> A microservices-based platform to centralize and manage household data, starting with a **Family** service.

![Java](https://img.shields.io/badge/Java-Spring%20Boot-6DB33F?logo=springboot&logoColor=white)
![Gradle](https://img.shields.io/badge/Build-Gradle-02303A?logo=gradle&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL%2016-4169E1?logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Container-Docker%20Compose-2496ED?logo=docker&logoColor=white)
 
---

## 📌 About

**Home Data Platform** is a personal/home-data project built with a microservices architecture. Each domain of the household (family members, and more to come) lives in its own independent service with its own database, and a frontend consumes them.

The first service, **`service-family`**, manages family-related data and is fully containerized, so the whole stack can be started with a single command.

## 🧱 Architecture

```text

┌──────────────┐     REST           ┌──────────────────┐ JDBC ┌──────────────────┐
│ Frontend     │ ─────────────────▶ │ service-family   │ ─────────────────▶
│ family-db    │                    │ Spring Boot      │                 
│ (frontend/)  │                    │ :8081            │
│PostgreSQL 16 │
└──────────────┘
│ :5435 (host) │
└──────────────────┘ └──────────────────┘
└────────── Docker network: home-data-platform ──────────┘

```

## 🛠️ Tech Stack

| Layer | Technology |
| ---------------- | -------------------------------------------- |
| Backend | Java, Spring Boot, Spring Data JPA / Hibernate |
| Build tool | Gradle (wrapper included) |
| Database | PostgreSQL 16 (Alpine) |
| Infrastructure | Docker & Docker Compose |
| Frontend | `frontend/` directory |
 
## 📂 Project Structure

```
home-data-platform/
├── documentation/ # Project documentation
├── frontend/ # Web client
├── service-family/ # Family microservice (Spring Boot)
├── gradle/wrapper/ # Gradle wrapper files
├── docker-compose.yml # Orchestrates database + services
├── settings.gradle # Gradle multi-project settings
└── README.md
```

## 🚀 Getting Started
 
### Prerequisites
 
- [Docker](https://docs.docker.com/get-docker/) and Docker Compose
- JDK 17+ *(only if you want to run the service outside Docker)*
### 1. Clone the repository
 
```bash
git clone https://github.com/KleberVales/home-data-platform.git
cd home-data-platform
```
 
### 2. Configure environment variables

Create a `.env` file in the project root:
 
```env
USER_DB_NAME=family_db
USER_DB_USERNAME=postgres
USER_DB_PASSWORD=change-me
```

> ⚠️ `USER_DB_NAME` should be `family_db`, since the service connects to `jdbc:postgresql://family-db:5432/family_db`.
> Never commit your `.env` file.

### 3. Start the platform
 
```bash
docker compose up --build
```
 
Docker Compose will:
 
1. Start **`family-db`** (PostgreSQL) and wait for its healthcheck to pass.
2. Build and start **`service-family`** once the database is healthy.
### 4. Access
 
| Service | URL / Address |
| ---------------- | ------------------------ |
| Family API | http://localhost:8081 |
| PostgreSQL (host)| `localhost:5435` |
 
### Stop the platform
 
```bash
docker compose down # stop containers
docker compose down -v # stop and remove database volume
```
 
## ⚙️ Services
 
### `service-family`
 
- Spring Boot REST microservice on port **8081**
- Persists data in PostgreSQL through Spring Data JPA
- Schema managed automatically (`SPRING_JPA_HIBERNATE_DDL_AUTO=update`)
- Starts only after the database passes its healthcheck
### `family-db`
 
- PostgreSQL 16 (Alpine) with a persistent named volume (`family_db_data`)
- Exposed on host port **5435** to avoid clashing with a local Postgres
- Healthcheck via `pg_isready`

## 🧪 Running Locally (without Docker for the service)
 
```bash
# Start only the database
docker compose up family-db
 
# Run the service with Gradle
./gradlew :service-family:bootRun
```

## 🗺️ Roadmap

- [ ] Document the Family API endpoints (OpenAPI / Swagger)
- [ ] Add new domain microservices
- [ ] Containerize the frontend in `docker-compose.yml`
- [ ] Add an API gateway
- [ ] Add automated tests and CI with GitHub Actions
- [ ] Replace `ddl-auto=update` with migrations (Flyway/Liquibase)
      
## 🤝 Contributing

1. Fork the project
2. Create your branch: `git checkout -b feature/my-feature`
3. Commit your changes: `git commit -m "feat: add my feature"`
4. Push to the branch: `git push origin feature/my-feature`
5. Open a Pull Request

   ---

   ## Kleber Vales

   **LinkedIn:**
