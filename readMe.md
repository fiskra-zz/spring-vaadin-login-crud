# SIMPLE VAADIN - SPRING BOOT PROJECT

## Getting Started

### Infrastructure

##### JAVA 8
##### Maven 
##### Spring-Boot and other dependencies(data-jpa, test)
##### Vaadin
##### H2 in-memory db
##### Angular.js
##### Bootstrap

### Prerequisites
DKLDL

## Installing

Just clone the project and run `Application.java` class.

#### What is Vaadin?
Vaadin is an open-source Java framework for building modern web applications that look great and well designed. In contrast to JavaScript libraries and browser-plugin based solutions, it features a server-side architecture, which means that the majority of the logic runs on the servers. 
[Vaadin wiki](https://en.wikipedia.org/wiki/Vaadin)

Vaadin provides two development models: for the server-side and for client-side(the browser).Here is the architecture:

![Vaadin Framework - Vaadin Architecture - Overview](https://github.com/fiskra/spring-vaadin-login-crud/tree/master/src/main/resources/images/architecture-detailed.png)

The Server-driven development is more powerful one, to allow development by utilizing an AJAX based Vaadin Client-Side Engine.
The client-side model allows developing widgets and applications in Java, which are compiled to JavaScript and executed in the browser.

##### UI Class 
The user interface of the application is implemented as a UI class(`VaadinUI.java`), which needs to create and manage the user interface components that make up the user interface. User input is handled with event listeners, although it is also possible to bind the user interface components directly to data. 

#### How Vaadin and Spring Boot work together? 

In Spring Boot applications you just need to annotate it with `@SpringUI` and it will be automatically picked up by Spring.

## Running the tests
