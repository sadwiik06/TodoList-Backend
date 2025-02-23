# TodoList-Backend

This is a backend-only To-Do List project built using Spring Boot and MySQL. It provides a REST API for managing to-do tasks, including CRUD operations (Create, Read, Update, Delete).

Tech Stack
Spring Boot (REST API)
Spring Data JPA (ORM)
MySQL (Database)
Maven (Dependency Management)
Postman (API Testing)

Features
✅ Get all to-dos
✅ Add a new to-do
✅ Update an existing to-do
✅ Delete a to-do
✅ Environment variable support for database credentials

Installation & Setup
Clone the repository:

git clone https://github.com/sadwiik06/TodoList-Backend.git
cd todolist


Configure your database:

Use an .env file or system environment variables to store database credentials.
Example .env file:
DB_URL=jdbc:mysql://localhost:3306/todo_db
DB_USERNAME=root
DB_PASSWORD=yourpassword
Update application.properties to use these values.


Run the application

API Endpoints:
Method	  Endpoint	          Description
GET	      /todos/	            Get all to-dos
GET  	    /todos/{id}       	Get a to-do by ID
POST	    /todos/add         	Add a new to-do
PUT	      /todos/update/{id}	Update a to-do
DELETE	  /todos/delete/{id}	Delete a to-do

Test using Postman or anything you use
