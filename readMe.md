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

![Vaadin Framework - Vaadin Architecture - Overview](https://github.com/fiskra/spring-vaadin-login-crud/blob/master/src/main/resources/images/architecture-detailed.png)

The Server-driven development is more powerful one, to allow development by utilizing an AJAX based Vaadin Client-Side Engine.
The client-side model allows developing widgets and applications in Java, which are compiled to JavaScript and executed in the browser.

##### UI Class 
The user interface of the application is implemented as a UI class(`VaadinUI.java`), which needs to create and manage the user interface components that make up the user interface. User input is handled with event listeners, although it is also possible to bind the user interface components directly to data. 

##### Application Architecture
When application codes grow the beyond of thousand lines, we should consider application architecture more to manage and protect stability of our application. There are many java design patterns outside, we already know that **mvc** is a common web application pattern but vaadin offers **mvp** whick is better than **mvp**. I can hear your words how it's possible?  There is also **Layered Architecture** design which provides three layers : Data access layer, domain layer, presentation layer. I'm gonna pick mvp design architecture.

###### MVP
The Model-View-Presenter (MVP) pattern is similar to the older Model-View-Controller (MVC) pattern. Instead of an implementation-aware controller, there is an implementation-agnostic presenter that operates the view through an interface. The view does not interact directly with the model. This isolates the view implementation better than in MVC and allows easier unit testing of the presenter and model.

![Vaadin Framework - MVP Pattern](https://github.com/fiskra/spring-vaadin-login-crud/blob/master/src/main/resources/images/mvp-pattern-hi.png)

#### How Vaadin and Spring Boot work together? 

In Spring Boot applications you just need to annotate it with `@SpringUI` and it will be automatically picked up by Spring.

## Running the tests
