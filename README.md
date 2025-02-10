# SimpleProject

* [English](README.md)
* [繁體中文版README.md](README.zh-TW.md)

## Project Description
SimpleProject is a sample project showcasing the basic structure of the Spring Boot framework and Spring MVC architecture. It uses MySQL's official Sakila Sample Database as a foundation to implement data retrieval, creation, updating, and deletion functionalities. This project is designed to meet industry-standard frontend-backend separation, focusing on the Controller (C) and Model (M) components while providing RESTful APIs.

## Features
1. Basic CRUD (Create, Read, Update, Delete) functionality.
2. User authentication with login and logout capabilities.

## Technologies Used
This project is developed using Java with the Spring Boot framework and runs on an embedded Tomcat server. The key technologies used in different modules are:

### Controller (C)
- **RESTful API**: All request URLs follow RESTful API standards.
- **Parameter and Object Validation**: `@RequestParam` and `@RequestBody` are validated using custom methods or `jakarta.validation.Valid` to prevent errors.
- **Security Management**:
  - Spring Security: Handles authentication and cross-origin resource sharing (CORS).
  - JSON Web Token (JWT): Ensures that certain API endpoints require authentication by verifying issued tokens.

### Model (M)
- **Database Interaction**: Uses MyBatis 3 to map and interact with SQL databases via XML configurations for CRUD operations.
- **Caching**:
  - Utilizes Redis for caching.
  - Integrates Spring Cache Manager with Redis Server, combining Spring Boot, MyBatis, and Redis for optimized performance.

### Other Technologies
- **Exception Handling**: Uses `@ControllerAdvice` to implement a unified exception handler, streamlining error logging and debugging.

## Installation Steps
Installation steps are not provided at this time.

## Usage
Usage details are not provided at this time.

## Contribution Guidelines
We welcome contributions to this project! To contribute, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix (e.g., `feature/feature-name`).
3. Submit a pull request with a detailed description of your changes.

## License
Currently, no specific license is assigned. Please contact the author for permission if you wish to use or distribute this project.

## Additional Information
This project emphasizes system performance and stability:
- Avoids using `*` in database queries for efficient data retrieval.
- Prefers `switch` statements over nested `if` conditions for better readability and performance.
- Carefully manages variable declarations to minimize unnecessary memory usage and prevent memory leaks.

For any questions or suggestions, feel free to contact the author!

