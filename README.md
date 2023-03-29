# Bug Pilot 🚀 - Server Code

A a simple yet powerful bug tracking app built with ReactJs for the frontend and Springboot for the backend APIs. It provides full CRUD functionality to help you efficiently track and manage bugs in your software development process.

## Features

- Create new bug reports with a title, description, and status
- View a list of all bug reports, sorted by date
- Edit existing bug reports and update their information
- Delete bug reports that are no longer relevant
- Search for specific bug reports using keywords or phrases

## Project Details

- Project Title: Bug Tracker
- Project Description: Bug Tracker System for HSC Major Project using Spring-Boot and MySQL as Backend Technologies
- Project Version: 1.0.0

## Prerequisites

1. Java 8
2. Maven installed
3. Mysql installed
4. Postman installed (**Curl** can be used as well)

## Getting Started

To get started with this project, please follow the below steps:

1. Clone the repository to your local machine using the command

   ```sh
   git clone https://github.com/ADITYAMAHAKALI/bug-tracker-backend.git
   ```

2. Navigate to the project directory containing the `pom.xml` file

   ```sh
   cd BugTracker
   ```

3. Create a MySQL database with the name `bugtracker`

   ```mysql
   CREATE DATABASE bugtracker;
   ```

4. Choose your favorite IDE and import the project. Once imported, you can run the project.
5. Add the proper username and password for the database in the `application.yaml` file

   ```yaml
   spring:
   datasource:
     url: jdbc:mysql://localhost:3306/bugtracker
     username: root
     password: root-password
   ```

6. Install the project dependencies

   ###### For Windows

   ```sh
   mvn clean install
   ```

   ###### For Linux/Mac

   ```sh
   ./mvnw clean install
   ```

7. Start the application

   ###### For Windows

   ```sh
   mvn spring-boot:run
   ```

   ###### For Linux/Mac

   ```sh
   ./mvnw spring-boot:run
   ```

Congratulations! You are now ready to use this project.

## License

This app is licensed under the GNU License. See the [LICENSE](./LICENSE) file for more information.

## Project ToDos

- [x] Writing and fianlizing Concise Requirements
- [x] Create Database Schema
- [x] Configure Application.yaml
- [x] Creation of Pojo classes
- [x] Creation of DaoRepositories
- [x] Creation of Services Interfaces
- [x] Creation of Services Implementations
- [ ] Creation of Rest_Controllers
- [ ] Adding Unit Tests
- [ ] Adding Outh 2.0 to secure Api's
- [ ] Adding Swagger to document Api's
- [ ] Corverting the project to Microservices
- [ ] Adding Docker to containerize the project

## List of Rest Apis to be created

- [ ] User

  - [x] Create User
  - [ ] Update User
  - [ ] Delete User
  - [ ] Get User
  - [ ] Get All Users

- [ ] Project

  - [ ] Create Project
  - [ ] Update Project
  - [ ] Delete Project
  - [ ] Get Project
  - [ ] Get All Projects
  - [ ] Get All Projects by a user

- [ ] ProjectRoles

  - [ ] Create ProjectRoles
  - [ ] Update ProjectRoles
  - [ ] Delete ProjectRoles
  - [ ] Get ProjectRoles
  - [ ] Get All ProjectRoles

- [ ] Bug
  - [ ] Create Bugs in project
  - [ ] Update Bug in project
  - [ ] Delete Bug
  - [ ] Get Bug
  - [ ] Get All Bugs in a project
        = [ ] Get All Bugs in a project by a user
  - [ ] Get All Bugs in a project by a user and a status
