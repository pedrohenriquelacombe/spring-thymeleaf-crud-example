# Spring Thymeleaf CRUD example

This project is an example of a **basic CRUD using MVC principles and Thymeleaf Template Engine**.

## About

The main goal of this project is to serve as a **basis to start the development of a new Spring Thymeleaf application**.

There are some jQuery functions implemented in some pages, like:
- Search address by your ZipCode;
- ZipCode and Date masks;

## Technologies

- [Lombok](https://projectlombok.org)
- [Thymeleaf](https://www.thymeleaf.org)
- [H2 Database](https://www.h2database.com/html/quickstart.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Validation](https://beanvalidation.org)

## Vendors

- [Jquery](https://jquery.com)
- [Bootstrap](https://getbootstrap.com)
- [Fontawesome](https://fontawesome.com)
- [Jquery Mask](https://igorescobar.github.io/jQuery-Mask-Plugin)

## Features

- DTO (Data Transfer Object) principles
- Thymeleaf Layout Dialect
- Custom Exception Handler pages

## Built With

- [Maven](https://maven.apache.org/index.html)
- [Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.3.RELEASE&packaging=jar&jvmVersion=11&groupId=com.example&artifactId=thymeleaf&name=SpringThymeleafCRUD&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.thymeleaf&dependencies=web,devtools,h2,validation,thymeleaf,data-jpa,lombok)

## How can i test my endpoints?

First, open your preference code editor and run the following code below:

```
mvn clean install
```

After the maven downloaded all dependencies, run the **SpringThymeleafTemplateApplication.class**.
