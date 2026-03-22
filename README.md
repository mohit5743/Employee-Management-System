# Employee Management System (Spring Boot)

A backend REST API built using Spring Boot to manage employee data with clean architecture and production-level practices.

## 🚀 Features

- Full CRUD APIs (GET, POST, PUT, DELETE)
- Layered Architecture (Controller → Service → Repository)
- DTO pattern for clean API design
- Global Exception Handling
- Email validation (duplicate check)
- Dynamic age calculation from DOB
- Pagination & Sorting support

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL

## 📌 API Endpoints

| Method | Endpoint | Description |
|--------|---------|------------|
| GET    | /api/v1/employee | Get all employees |
| GET    | /api/v1/employee/paged | Get paginated employees |
| POST   | /api/v1/employee | Create employee |
| PUT    | /api/v1/employee/{id} | Update employee |
| DELETE | /api/v1/employee/{id} | Delete employee |

## ⚙️ How to Run

1. Clone the repo
2. Configure MySQL in `application.properties`
3. Run the Spring Boot application

## 💡 Key Learnings

- Implemented DTO pattern for separation of concerns
- Built clean layered architecture
- Handled exceptions globally for better API responses
- Added pagination for efficient data handling
