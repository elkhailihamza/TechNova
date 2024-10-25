# TechNova
This application is a basic User Management System built using Spring Framework (Not Spring boot) and is XML based. It allows users to perform CRUD operations such as creating, viewing users through a web interface.

## Technologies Used

### Spring Framework - Which provides the following:
- **Spring Context**: For managing java beans.
- **Spring WebMVC**: For Dispatcher-Servlet that controls where the request goes to what mapped controller plus a view resolver.
- **Spring JDBC**: For connecting creating a Data Source for Entity Manager Factory creation and transaction management.
- **Spring orm**: For creating the Entity Manager Factory by given db properties plus hibernate configuration.

### Other
- **JAKARTA EE**: For building enterprise-level applications.
- **Hibernate**: For ORM (Object-Relational Mapping) and database interactions.

## Table of Contents
- [Project Structure](#project-structure)
- [Dependency Injection (DI)](#dependency-injection-di)
- [Inversion of Control (IoC)](#inversion-of-control-ioc)
- [Spring Beans](#spring-beans)
- [Bean Scopes](#bean-scopes)
- [ApplicationContext](#applicationcontext)
- [Component Scanning and Stereotype Annotations](#component-scanning-and-stereotype-annotations)
- [Spring Data JPA](#spring-data-jpa)
- [Spring MVC](#spring-mvc)
- [Installation and Setup](#installation-and-setup)

### I. Project Structure
  ```bash
  /src          # Main project folder
    |--- /main          # Main project folder
        |--- /java          # Main project folder
            |--- /org/project          # Main project folder
                |--- /controller          # Contains all Controllers
                    |--- HomeController.java          # (Class) Extends "MainController" and overrides the method "handleGetRequest()" that returns 'home' as ModelAndView
                    |--- MainController.java          # (Class) Implements "Controller" interface and overrides one method from which it separates the request method, POST or GET, into either methods "handlePostRequest()" or "handleGetRequest()"
                    |--- UserController.java          # (Class) Extends "MainController" and overrides both "handlePostRequest()" and "handleGetRequest()" to either create a new user or return 'user' as ModelAndView
                |--- /model          # Contains all entities or models
                    |--- User.java          # (Class) Has all db columns and is hibernate configured
                |--- /repository          # Contains all repositories
                    |--- /implementations          # Contains all repository implementations
                        |--- UserRepositoryImpl.java          # (Class) Is an implementation of UserRepository.java
                    |--- GenericRepository.java          # (Interface) Contains all CRUD operations
                    |--- UserRepository.java          # (Interface) Extends GenericRepository.java, currently is empty, could be used to give 'User' specific methods
                |--- /service          # Holds all services
                    |--- UserService.java          # (Class) Used to separate business logic from technical logic by injecting (DI) UserRepositoryImpl into it
        |--- /resources          # Contains all application properties
            |--- application.example.properties          # (Properties) An example that shows application.properties schema
            |--- application.properties          # (Properties) Contains database properties
            |--- applicationContext.xml          # (XML) Used to connect "application.properties" database properties with 'Spring Framework' and create 'EntityManagerFactory' to be injected into repositories that then get injected into services
        |--- /webapp          # Has WEB-INF
            |--- /WEB-INF          # Contains Web details and jsp files
                |--- /view          # Holds jsp files
                    |--- home.jsp        # (JSP) home jsp file
                    |--- user.jsp          # (JSP) user jsp file
                |--- dispatcher-servlet.xml          # (XML) "applicationContext.xml" gets imported into it for service injection (DI) and is generally used to which controller gets used on which end-point that return a ModelAndView for use
                |--- web.xml          # (XML) Is used to initiate "dispatcher-servlet.xml" in this app, it has multiple other uses
  ```

### II. Dependency Injection (DI)

Dependency Injection is a fundamental aspect of the Spring framework, through which the Spring container “injects” objects into other objects or “dependencies”. Simply put, this allows for loose coupling of components and moves the responsibility of managing components onto the container.

### III. Inversion of Control (IoC)

In software engineering, inversion of control (IoC) is a design principle in which custom-written portions of a computer program receive the flow of control from an external source (e.g. a framework).

Spring IoC (Inversion of Control) Container is the core of Spring Framework. It creates the objects, configures and assembles their dependencies, manages their entire life cycle. The Container uses Dependency Injection(DI) to manage the components that make up the application.

### IV. Spring Beans

The objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your application.

### V. Bean Scopes

A **bean's scope** refers to the lifecycle of the bean; things like how long the bean will live, how many instances will be created, and how the bean is shared in the Spring environment. The default scope for the bean is a singleton.

***All bean scopes***:
- **Singleton Scope**: The default scope in Spring, as mentioned before, singleton, ensures that a single instance of a bean is created per Spring IoC container.

- **Prototype**: The Prototype Scope. When prototype scope is used the Spring IoC container will create a new class instance every time a request the bean is made.

- **Request Scope**: creates a bean instance for a single HTTP request.

- **Session Scope**: The Spring container creates a new instance of a bean by using it's definition for the lifetime of a single HTTP Session.

- **Application Scope**: The Spring container creates a new instance of a bean by using it's bean definition once for the entire web application.

- **WebSocket scope**: in Spring defines a bean lifecycle that creates a new instance for each WebSocket session, allowing for stateful communication within that session.

### VI. ApplicationContext

**ApplicationContext** represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the aforementioned beans. The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata.

### VII. Component Scanning and Stereotype Annotations

**Component scanning** in Spring automatically detects and registers beans in the application context, while **stereotype annotations** (like ```@Component```, ```@Service```, ```@Repository```, and ```@Controller```) are used to indicate the role of a class in the Spring framework, simplifying the configuration of beans.

### VIII Spring Data JPA

**Spring Data JPA** is a part of the Spring Data project that simplifies data access and manipulation by providing a set of abstractions and functionalities to work with Java Persistence API (JPA) repositories, reducing boilerplate code.

### IX. Spring MVC

**Spring MVC** is a Java framework which is used to build web applications. It follows the Model-View-Controller design pattern. It implements all the basic features of a core spring framework like Inversion of Control, Dependency Injection.

### X. Installation and Setup

- To get started:
1. Install the latest release:

    ![GitHub release (latest by date)](https://img.shields.io/github/v/release/elkhailihamza/TechNova)

2. Install WAR package by maven:
   ```bash
   mvn clean install
   ```

3. Create database:
   ```bash
   |--- technova_DB.sql # Use this file to create a database. Note: syntax is in PostgreSQL
   ```

3. Connect database to application by using application.example.properties file schema to create an application.properties file:
  ```bash
  |--- /resources
      |--- application.example.properties # Has schema to create the file below
      |--- application.properties # Use the file above to create this. Will be used to give the application database details
  ```

4. Change to your heart's content
