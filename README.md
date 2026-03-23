# Employee Management System | Spring Boot

A backend REST API built using Spring Boot to manage employee data with clean architecture and production-level practices.

---

## 🚀 Features

- Full CRUD APIs (GET, POST, PUT, DELETE)
- Layered Architecture (Controller → Service → Repository)
- DTO pattern for clean API design
- Global Exception Handling (structured error responses)
- Email validation (duplicate check)
- Dynamic age calculation from DOB
- Pagination & Sorting support

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/v1/employee | Get all employees |
| GET | /api/v1/employee/pages?pageNo=0&pageSize=5&sortBy=id | Get paginated employees |
| POST | /api/v1/employee | Create employee |
| PUT | /api/v1/employee/{id} | Update employee |
| DELETE | /api/v1/employee/{id} | Delete employee |

---

## ⚙️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/mohit5743/Employee-Management-System.git
