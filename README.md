# Document Service (Java / Spring Boot)

A Java + Spring Boot rebuild of the Document Service from
[medical-knowledge-assistant](https://github.com/Yasmine-y-s/medical-knowledge-assistant),
connected to the same PostgreSQL database — demonstrating cross-language
interoperability on shared, real data.

## Scope

CRUD only: `POST/GET/GET-by-id/DELETE /documents`. No auth, RAG, or
agent logic — those remain in the main project.

## Stack

Java 25 · Spring Boot 4.1 · Maven · Spring Data JPA · Lombok

## Running it

Requires the main project's Postgres running. Then:

./mvnw spring-boot:run

Runs on `http://localhost:8081`.
