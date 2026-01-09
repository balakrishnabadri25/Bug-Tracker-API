<div align="center">

  # Bug Tracker API

  A robust REST API for managing software projects and tracking bugs.

  [View Live Demo](#live-demo)

</div>

---

## About The Project

The Bug Tracker API is designed to streamline the software development lifecycle. It allows teams to organize projects and log bugs with specific priorities (High, Medium, Low) and statuses (Open, In Progress, Closed).

Built with Spring Boot, this project demonstrates clean architecture, relational database management (JPA), and standardized RESTful practices.

---

## Features

- Project Management: Create and view multiple software projects.
- Bug Tracking: Log detailed bugs with descriptions and priorities.
- Relationship Mapping: Connects Bugs to Projects using @ManyToOne relationship.
- Advanced Filtering: Retrieve bugs by status or priority.
- Status Workflow: Quick endpoint to close bugs automatically.
- API Documentation: Integrated Swagger UI for interactive testing.
- Exception Handling: Global error handling for robust responses.

---

## Tech Stack

- Java 21
- Spring Boot 3.3.0
- Spring Data JPA
- Maven
- PostgreSQL
- Lombok
- Swagger (OpenAPI)

---

## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

- JDK 21 installed.
- Maven installed.
- PostgreSQL installed.

### Installation

1. Clone the repo
   git clone https://github.com/YOUR_USERNAME/bug-tracker.git

2. Configure Database
   Open src/main/resources/application.properties and update:
   spring.datasource.url=jdbc:postgresql://localhost:5432/bugtracker_db
   spring.datasource.username=YOUR_DB_USERNAME
   spring.datasource.password=YOUR_DB_PASSWORD

3. Build the project
   mvn clean install

4. Run the application
   mvn spring-boot:run

---

## API Documentation

This project uses SpringDoc OpenAPI to generate interactive documentation.

### Live Demo
[ADD YOUR RENDER LINK HERE](https://your-app-url.onrender.com/swagger-ui/index.html)

### Example Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| POST | /api/projects | Create a new Project |
| GET | /api/projects | Get all Projects |
| POST | /api/bugs | Create a new Bug |
| GET | /api/bugs/project/{id} | Get bugs by Project |
| PUT | /api/bugs/{id}/close | Close a specific Bug |

---

## Contact

Your Name - [GitHub Link](https://github.com/YOUR_USERNAME)

Project Link: https://github.com/YOUR_USERNAME/bug-tracker
