# Library Management System

## Project Description

This project is a Library Management System API built using Spring Boot. The system allows librarians to manage books, patrons, and borrowing records through a RESTful API.

## Features

- **Book Management:** CRUD operations for books.
- **Patron Management:** CRUD operations for patrons.
- **Borrowing Management:** Operations to allow patrons to borrow and return books.
- **Validation:** Input validation and error handling.
- **Optional Features:** Basic authentication, logging with AOP, caching, and transaction management.

## Project Setup

### 1. Initialize the Project

Use [Spring Initializr](https://start.spring.io/) to generate the project with the following dependencies:

- Spring Web
- Spring Data JPA
- H2 Database (or MySQL/PostgreSQL)
- Lombok
- Spring Boot DevTools

### 2. Configure the Database

Edit `src/main/resources/application.yml` to configure your database connection. Use H2 for development or MySQL/PostgreSQL for production.

**Example `application.yml` for H2:**
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:librarydb;DB_CLOSE_DELAY=-1
    driver-class-name: org.h2.Driver
    username: sa
    password: password
  h2:
    console:
      enabled: true
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.H2Dialect
