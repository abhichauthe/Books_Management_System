# Book Management System

A simple Spring Boot RESTful API for managing books.

## Technologies
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (in-memory)
- Maven

## Setup and Running
1. Ensure Java 17 is installed
2. Clone the repository
3. Run `mvn spring-boot:run`
4. Access the API at `http://localhost:8080`

## API Endpoints

1. Create a Book
   POST `/api/books`
   Body: {"title": "Book Title", "author": "Author Name", "isbn": "1234567890", "publicationYear": 2023}

2. Get All Books
   GET `/api/books`

3. Get a Book by ID
   GET `/api/books/{id}`

4. Update a Book
   PUT `/api/books/{id}`
   Body: {"title": "Updated Title", "author": "Author Name", "isbn": "1234567890", "publicationYear": 2023}

5. Delete a Book
   DELETE `/api/books/{id}`

## Testing (using curl)

1. Create: 
   curl -X POST http://localhost:8080/api/books -H "Content-Type: application/json" -d '{"title":"Godan","author":"Premchand","isbn":"9788126415403","publicationYear":1936}'

2. Get All: 
   curl http://localhost:8080/api/books

3. Get by ID: 
   curl http://localhost:8080/api/books/1

4. Update: 
   curl -X PUT http://localhost:8080/api/books/1 -H "Content-Type: application/json" -d '{"title":"Train to Pakistan","author":"Khushwant Singh","isbn":"9780143065883","publicationYear":1956}'

5. Delete: 
   curl -X DELETE http://localhost:8080/api/books/1

Example Books for Testing:
1. "Godan" by Premchand
2. "Train to Pakistan" by Khushwant Singh
3. "The God of Small Things" by Arundhati Roy
4. "Midnight's Children" by Salman Rushdie
5. "Gaban" by Premchand
6. "The White Tiger" by Aravind Adiga
7. "Nirmala" by Premchand
8. "A Suitable Boy" by Vikram Seth

This Spring Boot application demonstrates basic CRUD operations for a Book entity, providing a foundation for more complex book management systems.
