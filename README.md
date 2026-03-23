 Employee Management System | Spring Boot

A backend REST API built using Spring Boot to manage employee data with clean architecture and production-level practices.

---

 🚀 Features

- Full CRUD APIs (GET, POST, PUT, DELETE)
- Layered Architecture (Controller → Service → Repository)
- DTO pattern for clean API design
- Global Exception Handling (structured error responses)
- Email validation (duplicate check)
- Dynamic age calculation from DOB
- Pagination & Sorting support

---

 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL

---

 📌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/v1/employee | Get all employees |
| GET | /api/v1/employee/pages?pageNo=0&pageSize=5&sortBy=id | Get paginated employees |
| POST | /api/v1/employee | Create employee |
| PUT | /api/v1/employee/{id} | Update employee |
| DELETE | /api/v1/employee/{id} | Delete employee |

---

 ⚙️ How to Run

1. Clone the repository:
```bash
git clone https://github.com/mohit5743/Employee-Management-System.git

---
 2. Create database in MySQL:

CREATE DATABASE Employee;
---
 3.Configure MySQL in src/main/resources/application.properties:
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
---

 4. Run the application:
./mvnw spring-boot:run
---

5. API is live at:
http://localhost:8080/api/v1/employee
---

📥 Sample POST Request
{
  "firstName": "Rahul",
  "secondName": "Sharma",
  "email": "rahul.sharma@example.com",
  "department": "Finance",
  "designation": "Analyst",
  "salary": 18000,
  "joindate": "2024-01-15",
  "dob": "1998-05-20"
}
📂 Project Structure
src/main/java/com/example/demo/Employee/
├── Config/
│   └── EmployeeConfig.java
├── Controller/
│   └── EmployeeController.java
├── Dto/
│   └── EmployeeDto.java
├── Exception/
│   └── GlobalExceptionHandler.java
├── Model/
│   └── Employee.java
├── Repository/
│   └── EmployeeRepository.java
└── Service/
    └── EmployeeService.java

🧠 Project Highlights
Designed clean layered architecture for maintainability and scalability
Implemented DTO pattern to decouple API from database entities
Added global exception handling for consistent API responses
Integrated pagination and sorting for efficient data retrieval
Focused on writing clean, readable, and production-style code
📈 Future Improvements
Add authentication using Spring Security & JWT
Deploy application (Render / Railway / AWS)
Add unit and integration testing (JUnit, Mockito)
Integrate Swagger for API documentation
⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub!

📬 Contact

Mohit Chopra
Java Backend Developer | Open to Work

🔗 LinkedIn: https://www.linkedin.com/in/mohit-chopra

🔗 GitHub: https://github.com/mohit5743
