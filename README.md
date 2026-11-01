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
 


