# Leave Management System
## Simple Application For Managing Employee Leaves.

### Description
Leave Management System is a web application for managing employee leaves. This application provides all the things that a project/team needs. Through this application one can easily manage leaves. Application maintenance is easy.

### Requirements
* Java 11 or higher(Java 18 preferred).
* Maven
* Spring Boot 2.7.7 (Spring Data JPA)
* Hibernate 
* Oracle Database
* JSP

### How To Run
* As it's a Maven Project, you need to install Maven in your IDE.
* You need to have Oracle database.
* Change Oracle database Username and Password form the Application Properties with your database details.
* You can find all the controllers , Models , Repository , and Service class in respective Packages.
* Make sure that all the necessary installation should be done before starting the project.
* After that run the project as spring boot project from ur IDE. 

### Application Functionality
* It provides a one-stop platform to view and apply leave.
*  The HR can easily upload the holiday list of the current year.
*  HR can easily upload the details of the projects of the organization.
*  HR can introduce new employee into the organization through a simple form.
*  HR can manage all the leaves applied by the employee.
*  The employees can view his/her leave balance

HR is generally treated as the Admin in this project. Initially, the Admin
introduces an employee to the organization. The Admin will create an account
for each employee by entering details of that particular employee in the form
provided. Each employee gets an email through which a user can log in into his/
her portal.

When the leave is approved by the Manager the mail is sent to the employee.
The Manager can view all the applied leaves and the details of all cleared
leaves. The employee cannot approve or reject any leave.
* An employee can view his leave balance on the same page where
he has the form to apply for leave.
* The user can apply for both single day leaves and multiple day
leaves. After the leave is applied, it can be viewed in a separate tab.
* The employee gets a notification and official mail when his leave is
approved or rejected.
* An employee can view all the holidays of the current year. The
Employee can also view his details in his profile.

### Apllication Overview
## pom.xml file
pom.xml file having all the necessary dependencies required for the project.
 
## springBootApplication file
# src/main/java/com/example/demo/LeaveManagementPortal1Application
* spring boot application file for configuring he spring web project.

## All the Controllers class are inside this folder
# src/main/java/com/axis/lms/app/controller
* 1. EmployeeController.java 
* 2. HrController.java 
* 3. ManagerController.java 

## All the Model class are inside this folder
# src/main/java/com/axis/lms/app/entity
* 1. Employee.java 
* 2. ApplyLeave.java
* 3. Project.java
* 4. Holiday.java

## All the Repository class are inside this folder
# src/main/java/com/axis/lms/app/repoisitory
* 1. EmployeeRepository.java 
* 2. ApplyLeaveRepository.java
* 3. HolidayRepository.java
* 4. ProjectRepository.java

## All the Service class are inside this folder
# src/main/java/com/axis/lms/app/service
* 1. IEmployeeService.java 
* 2. IHrService.java
* 3. IManagerService.java
Service Interface and implementation classes

## Application Properties file
# src/main/resourses/application.properties
* All the database configuration details and hibernate details are given globally.

## web Pages file
# src/main/webapp/views
* All the html and jsp web pages are inside this folder.
