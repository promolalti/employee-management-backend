# Employee Management System - Backend

## Overview

Employee Management System Backend is a Spring Boot application designed to manage employees, departments, users, roles, permissions, authentication, audit logs, and dashboard statistics.

## Technology Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Liquibase
- Maven
- JWT Authentication
- HikariCP Connection Pool
- Lombok

---

## Features

### Authentication
- Login
- JWT Access Token
- Refresh Token
- Password Reset
- Role-Based Access Control (RBAC)

### User Management
- Create User
- Update User
- Activate/Deactivate User
- Assign Roles

### Role Management
- Create Role
- Update Role
- Assign Permissions

### Permission Management
- Module-based permissions
- RBAC implementation

### Employee Management
- Add Employee
- Update Employee
- Employee Search
- Employee Status Management

### Department Management
- Create Department
- Update Department
- Department Manager Assignment

### Audit Logs
- User Activity Tracking
- Request Logging
- Entity Change Tracking

### Dashboard
- Total Employees
- Total Departments
- Active Users
- System Statistics

---

## Database

Database: MySQL

Liquibase is used for database version control and migration management.

### Main Tables

- roles
- permissions
- role_permissions
- users
- user_roles
- departments
- employees
- refresh_tokens
- password_reset_tokens
- audit_logs

---

## Project Structure

```text
src/main/java/com/promolati/ems

├── config
├── security
├── authentication
├── user
├── role
├── permission
├── department
├── employee
├── audit
├── dashboard
├── common
├── exception
└── util
```

## Liquibase Structure

```text
src/main/resources/db/changelog

├── db.changelog-master.xml
├── 001-create-role-table.xml
├── 002-create-permission-table.xml
├── 003-create-role-permission-table.xml
├── 004-create-user-table.xml
├── 005-create-user-role-table.xml
├── 006-create-department-table.xml
├── 007-create-employee-table.xml
├── 008-create-refresh-token-table.xml
├── 009-create-password-reset-token-table.xml
├── 010-create-audit-log-table.xml
└── 012-add-user-employee-fk.xml
```

---

## Running the Application

### Clone Repository

```bash
git clone https://github.com/promolalti/employee-management-backend.git
```

### Configure Database

Update:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=root
spring.datasource.password=root
```

### Run Application

```bash
mvn clean install
mvn spring-boot:run
```

---

## Author

Promolalti
