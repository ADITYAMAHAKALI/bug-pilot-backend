# bug-tracker-backend

## Project Details
- Project Title: Bug Tracker
- Project Description: Bug Tracker System for Hsc Major Project using Spring-Boot and Mysql as Backend Technologies
- Project Version: 1.0.0

__________________________________________________

## Project Setup

### Prerequisites

1. Java 8
2. Maven installed
3. Mysql installed
4. Postman installed(you can use curl as well)

### Steps to run the project
1. clone the repo.
2. cd into the project directory with pom.xml.
3. Choose your favorite IDE and import the project and run the project.
3. run `mvn clean install` or '`.\mvnw` for windows and `./mvnw` for linux/mac.
4. run `mvn spring-boot:run` or `.\mvnw` for windows and `./mvnw` for linux/mac.
5. create a databse with name bugtracker im MySQl.
6. Add Proper username and password in application.yaml file for the database.
__________________________________________________

## Project ToDos 
- [X] Writing and fianlizing Concise Requirements
- [X] Create Database Schema
- [X] Configure Application.yaml
- [X] Creation of Pojo classes
- [X] Creation of DaoRepositories
- [X] Creation of Services Interfaces
- [X] Creation of Services Implementations
- [ ] Creation of Rest_Controllers
- [ ] Adding Unit Tests
- [ ] Adding Outh 2.0 to secure Api's
- [ ] Adding Swagger to document Api's
- [ ] Corverting the project to Microservices
- [ ] Adding Docker to containerize the project

________________________________________________
## List of Rest Apis to be created
- [ ] User
    - [X] Create User
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





