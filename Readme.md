# Library Management System API

## Overview

This project is a Library Management System API built using Spring Boot. The system allows librarians to manage books, patrons, and borrowing records. It provides RESTful endpoints for CRUD operations on books and patrons, as well as functionality for borrowing and returning books.

## Features

- **Book Management:**
  - Retrieve a list of all books.
  - Retrieve details of a specific book by ID.
  - Add a new book to the library.
  - Update an existing book's information.
  - Remove a book from the library.

- **Patron Management:**
  - Retrieve a list of all patrons.
  - Retrieve details of a specific patron by ID.
  - Add a new patron to the system.
  - Update an existing patron's information.
  - Remove a patron from the system.

- **Borrowing Records:**
  - Allow a patron to borrow a book.
  - Record the return of a borrowed book.

- **Optional Features:**
  - Basic authentication or JWT-based authorization.
  - Logging using Aspect-Oriented Programming (AOP).
  - Caching of frequently accessed data.
  - Transaction management for data integrity.

## Technology Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (or MySQL/PostgreSQL)
- **Spring Security** (optional)
- **Spring Cache** (optional)
- **JUnit and Mockito** for testing

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17+
- Maven 3.x+
- Git

### Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/Library-Management-System.git
cd Library-Management-System
