# Spring Boot Hibernate JPA CRUD Project

## Overview

This project is a **Command Line Application** developed using **Spring Boot** with **Hibernate/JPA** for database management. The application is designed to perform basic CRUD (Create, Read, Update, Delete) operations on a MySQL database.

## Technologies Used

- **Java**: Programming language used to develop the application.
- **Spring Boot**: Framework for building the application.
- **Hibernate/JPA**: ORM tool for managing database interactions.
- **MySQL**: Relational database used for data storage.
- **Maven**: Build automation tool.

## Prerequisites

- **Java 8 or higher**
- **Maven 3.9.7**
- **MySQL 8.0.39**

## Setup and Installation

1. **Clone the Repository**  
   Clone this repository to your local machine using:
   ```bash
   git clone https://github.com/your-username/spring-boot-hibernate-jpa-crud.git
   ```

2. **Configure MySQL Database**  
   Create a MySQL database and update the `application.properties` file with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Build the Project**  
   Navigate to the project directory and build the project using Maven:
   ```bash
   mvn clean install
   ```

4. **Run the Application**  
   Execute the application from the command line:
   ```bash
   java -jar target/your-jar-file.jar
   ```

## Usage

Once the application is running, you can perform CRUD operations through the command line interface:

- **Create**: Add new records to the database.
- **Read**: Retrieve records from the database.
- **Update**: Modify existing records.
- **Delete**: Remove records from the database.

## Project Structure

- `src/main/java`: Contains the Java source code.
  - `controller`: Handles the command line input and interaction.
  - `service`: Contains business logic.
  - `repository`: Handles data persistence using JPA.
  - `entity`: Defines the data model.
- `src/main/resources`: Contains configuration files like `application.properties`.
- `pom.xml`: Maven configuration file for managing dependencies.

## Contributing

If you'd like to contribute to this project, feel free to fork the repository and submit a pull request.


## Contact

If you have any questions or feedback, please feel free to reach out to me at omeralhaj911@gmail.com.
