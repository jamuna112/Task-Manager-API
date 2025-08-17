# Task Manager API

This is a RESTful API designed to manage tasks. It allows users to create, read, update, delete tasks. The API is built using **Spring Boot** and uses **H2** as the in-memory database for storage. This is a simple project designed to help learn how to build a backend API with **JAVA**, **SpringBoot** and **JPA**.

## Features

- **Create Tasks**: Add new tasks with a title and description.
- **Read Tasks**: Fetch a list of all tasks or a specific task by ID.
- **Update Tasks**: Mark tasks as done.
- **Delete Task**: Remove tasks from the database.
- **In-Memory Database**: Uses H2 database for task storage.
- **Basic Caching**: Implemented basic caching for better performances (tasks fetched frequently are cached).

## Technologies Used

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (In-memory)
- **Maven** (for dependency management)
- **Tomcat** (Embedded web server)

## Getting Started
### Prerequisites

- **Java 17** or higher
- **Maven** (or use Spring Boot's Maven plugin)
- IDE like **IntelliJ IDEA** or **VS Code** (optional, for code editing)

### Installation

1. Clone the repository to your local machine:

```bash
git clone https://github.com/your-username/task-manager-api.git
```

2. Navigate to the project folder:
```bash 
cd task-manager-api
```
3. Install dependencies using Maven (or use Spring Boot plugin for Maven):
```bash
mvn install
```
4. If using H2 database, no need to install anything else—it's configured for in-memory use.
```bash

### 6. **Running the Application**
Explain how to run the project after setup.

```markdown
### Running the Application

You can run the application using **Maven**:

```bash
mvn spring-boot:run

```
Alternatively, you can build and run the JAR file:

```bash
mvn clean package
java -jar target/task-manager-api-0.0.1-SNAPSHOT.jar

```

