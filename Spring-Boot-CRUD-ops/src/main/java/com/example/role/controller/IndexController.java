package com.example.role.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
        return "This project uses spring boot 1.2, Java 8 and MySQL 8, Maven 3. And you will need Postman for testing requests.\r\n" + 
        		"\r\n" + 
        		"First\r\n" + 
        		"\r\n" + 
        		"Create a database a MySQL 'roles_app' without commas.\r\n" + 
        		"Come the project and change the user and the password for localhost in application.properties according to machine's localhost.\r\n" + 
        		"Open the project folder in eclipse and run RoleApplication.java. Then the application will run on port 8080.\r\n" + 
        		"\r\n" + 
        		"Then open Postman and test the following CRUD operations.\r\n" + 
        		"\r\n" + 
        		"http://localhost:8080/api/role/       This GET request will all the roles.\r\n" + 
        		"http://localhost:8080/api/role/{nic}/{organization}    This GET request will roles by NIC and organization.\r\n" + 
        		"http://localhost:8080/api/role/{nic}   This GET request will roles by NIC. \r\n" + 
        		"http://localhost:8080/api/role       This POST request will create a new role. \r\n" + 
        		"http://localhost:8080/api/role/{id}  This PUT request will update an existing role.\r\n" + 
        		"http://localhost:8080/api/role/{id	 This DELETE request will delete and existing role\r\n" + 
        		"\r\n" + 
        		"The API documentation can be found at http://localhost:8080/swagger-ui.html#/role-controller\r\n" + 
        		"\r\n" + 
        		"Recommend to start testing with POST request and create some entities before run other requests";
    }
}
