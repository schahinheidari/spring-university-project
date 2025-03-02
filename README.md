
# Java Project with Layered Architecture (spring-university-project)

This project follows a **Layered Architecture** (MVC - Model-View-Controller) and adheres to best practices in software development. The code is divided into different layers to enhance readability, maintainability, and scalability. Below is an explanation of each part of the structure and the reasoning behind these separations.

---

## **1. Project Structure**
The project is structured using **Layered Architecture**, which includes the following layers:

- **Controller**: Handles HTTP requests and responses.
- **Service**: Implements business logic.
- **Repository**: Manages database interactions.
- **Entity**: Defines data models.
- **DTO (Data Transfer Object)**: Used for transferring data between layers.

---

## **2. Directory and File Explanation**

### **config**
This directory contains configuration files for the project. Examples include:
- **CaffeineCacheConfig.java**: Configuration for caching using the Caffeine library.
- **ModelMapperConfig.java**: Configuration for the ModelMapper library to automate Entity-DTO conversions.

### **controller**
Contains controller classes that manage HTTP requests. Controllers typically use services to perform operations.

### **dto**
Contains **DTO (Data Transfer Object)** classes used for transferring data between layers. DTOs are well-separated in this project:
- **base**: Includes base DTOs that may be used by other DTOs.
- **course**: Includes DTOs related to courses, such as:
  - **AddCourseDTO.java**: For adding a new course.
  - **UpdateCourseDTO.java**: For updating an existing course.
  - **ViewCourseDTO.java**: For displaying course information.
- **professor**: Includes DTOs related to professors.
- **student**: Includes DTOs related to students.
- **user**: Includes DTOs related to users.

### **entity**
Contains **Entity** classes that define data models. These classes are typically mapped to database tables. Examples include:
- **BaseEntity.java**: A base class that may include common fields like `id`, `createdAt`, and `updatedAt`.
- **Course.java**: Data model for courses.
- **Professor.java**: Data model for professors.
- **Student.java**: Data model for students.
- **User.java**: Data model for users.

### **enums**
Contains enumeration types used to define constant values.

### **exception**
Contains exception classes for error and exception handling.

### **mapper**
Contains mapper classes for converting between Entity and DTO. Libraries like **ModelMapper** or **MapStruct** are typically used for this purpose.

### **repository**
Contains repository classes that interact with the database. These classes usually use **Spring Data JPA**.

### **service**
Contains service classes that implement business logic. Services typically use repositories to access data.

### **SpringProjectApplication.java**
The main class of the project, used to bootstrap the application.

### **resources**
Contains resource files such as configuration files (application.properties or application.yml), XML files, and other resources.

### **test**
Contains unit tests and integration tests.

### **Dockerfile**
Used to build a Docker image of the project.
Build the Docker Image:

Run the following command to build the Docker image for the Spring Boot application:

```
docker build -t spring-project .
```
Start the Containers:

Use Docker Compose to start both the Spring Boot application and the MySQL database:

```
docker-compose up
```
Access the Application:

Once the containers are running, the Spring Boot application will be accessible at http://localhost:8080.

Stop the Containers:

To stop the containers, use the following command:

```
docker-compose down
```

---

## **3. Benefits of This Architecture**
- **Separation of Concerns**: Each layer has a specific responsibility, improving code readability and maintainability.
- **Testability**: With separated layers, unit and integration tests are easier to implement.
- **Reusability**: Code in different layers can be reused in other parts of the project or even in other projects.
- **Flexibility**: Changes in one layer have minimal impact on other layers.

---

## **4. Key Points**
- **Use of DTOs**: DTOs prevent unnecessary data transfer between layers and enhance security.
- **Use of Mappers**: Mappers automate Entity-DTO conversions, reducing manual coding.
- **Configurations**: Configurations are placed in separate files for easy modifications.

---
