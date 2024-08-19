Library Management System
Project Description
The Library Management System is an API built using Spring Boot that allows librarians to manage books, patrons, and borrowing records. The system provides endpoints for performing CRUD operations on books and patrons, as well as endpoints for handling book borrowing and return transactions.

Features
Book Management:

Retrieve all books
Retrieve a specific book by ID
Add a new book
Update an existing book's information
Remove a book
Patron Management:

Retrieve all patrons
Retrieve a specific patron by ID
Add a new patron
Update an existing patron's information
Remove a patron
Borrowing Records:

Borrow a book
Return a borrowed book
API Endpoints
Book Management
Retrieve all books: GET /api/books
Retrieve a specific book by ID: GET /api/books/{id}
Add a new book: POST /api/books
Update a book's information: PUT /api/books/{id}
Remove a book: DELETE /api/books/{id}
Patron Management
Retrieve all patrons: GET /api/patrons
Retrieve a specific patron by ID: GET /api/patrons/{id}
Add a new patron: POST /api/patrons
Update a patron's information: PUT /api/patrons/{id}
Remove a patron: DELETE /api/patrons/{id}
Borrowing Records
Borrow a book: POST /api/borrow/{bookId}/patron/{patronId}
Return a borrowed book: PUT /api/return/{bookId}/patron/{patronId}
Data Storage
The system uses a relational database (e.g., H2, MySQL, PostgreSQL) to persist data for books, patrons, and borrowing records. The relationships between these entities are established using JPA annotations.

Validation and Error Handling
Input validation is implemented for API requests to ensure data integrity. The application handles exceptions gracefully and returns appropriate HTTP status codes and error messages.

Security (Optional)
The API can be secured using basic authentication or JWT-based authorization to protect the endpoints.

Caching (Optional)
Spring’s caching mechanisms can be utilized to cache frequently accessed data, such as book details or patron information, to improve performance.

Transaction Management
Declarative transaction management is implemented using Spring's @Transactional annotation to ensure data integrity during critical operations.

Testing
Unit tests are provided to validate the functionality of the API endpoints. Testing frameworks such as JUnit, Mockito, and SpringBootTest are used to ensure comprehensive test coverage.

How to Run
Clone the repository:

bash
Copy code
git clone https://github.com/AyahAlNatour/Library-Management-System.git
cd Library-Management-System
Build the project using Maven:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
The API will be available at http://localhost:8080/api/.

Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

License
This project is licensed under the MIT License - see the LICENSE file for details.
