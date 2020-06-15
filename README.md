# Spring-Boot-CRUD-ops
This project uses spring boot 1.2, Java 8 and MySQL 8, Maven 3. And you will need Postman for testing requests.

First

Create a database a MySQL 'roles_app' without commas.
Come the project and change the user and the password for localhost in application.properties according to machine's localhost.
Open the project folder in eclipse and run RoleApplication.java. Then the application will run on port 8080.

Then open Postman and test the following CRUD operations.

http://localhost:8080/api/role/       This GET request will all the roles.
http://localhost:8080/api/role/{nic}/{organization}    This GET request will roles by NIC and organization.
http://localhost:8080/api/role/{nic}   This GET request will roles by NIC. 
http://localhost:8080/api/role       This POST request will create a new role. 
http://localhost:8080/api/role/{id}  This PUT request will update an existing role.
http://localhost:8080/api/role/{id	 This DELETE request will delete and existing role

The API documentation can be found at http://localhost:8080/swagger-ui.html#/role-controller

Recommend to start testing with POST request and create some entities before run other requests