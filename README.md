
# Spring Boot ToDo Application

This is a simple ToDo application built using Spring Boot, MySQL, and JSP.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed.
- MySQL Database Server installed and running.
- Maven installed.

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/suvracool/ToDo_SpringBoot.git

2. Open the application.properties file located in src/main/resources and configure your MySQL database settings:

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password


3.Create a MySQL database matching the configuration specified in application.properties.

4. Build the project using Maven.
5. Run the application.
mvn spring-boot:run

6.Open a web browser and access the application at http://localhost:8080.

**Usage**
The application allows you to create, view, update, and delete ToDo items.
You can register and log in using your username and password.

**Contributing**
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

Fork the project.
Create a new branch for your feature or bug fix.
Make your changes and commit them.
Submit a pull request with a clear description of your changes.
