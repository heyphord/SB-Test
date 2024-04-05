# DEMO-MICROSERVICE
Boiler plate code to start a new microservice

# DEFAULT SPING LIBRARIES

Lombok- DEVELOPER TOOLS
Java annotation library which helps to reduce boilerplate code.

Spring Boot DevTools- DEVELOPER TOOLS
Provides fast application restarts, LiveReload, and configurations for enhanced development experience.

Spring Web WEB
Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

Spring Security SECURITY
Highly customizable authentication and access-control framework for Spring applications.

Spring Data JPA SQL
Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

MySQL Driver SQL
MySQL JDBC driver.

Oracle Driver SQL
A JDBC driver that provides access to Oracle.

PostgreSQL Driver SQL
A JDBC and R2DBC driver that allows Java programs to connect to a PostgreSQL database using standard, database independent Java code.

Java Mail Sender I/O
Send email using Java Mail and Spring Framework's JavaMailSender.

Resilience4J SPRING CLOUD CIRCUIT BREAKER
Spring Cloud Circuit breaker with Resilience4j as the underlying implementation.

# PROJECT FOLDER STRUCTURE

├── src
│   ├── controller
│   │   ├── **/*.css
│   ├── views
│   ├── model
│   ├── index.js
├── public
│   ├── css
│   │   ├── **/*.css
│   ├── images
│   ├── js
│   ├── index.html
├── dist (or build
├── node_modules
├── package.json
├── package-lock.json
└── .gitignore

demo-microservice/
│
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.gmfs.demo/
│   │   │   │   ├── DemoApplication.java   # Main Spring Boot application class
│   │   │   │   │   
│   │   │   │   │
│   │   │   │   ├── model/                             # Domain models/entities
│   │   │   │   │   ├── Account.java
│   │   │   │   │   ├── Transaction.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   ├── repository/                        # Repository interfaces (persistence)
│   │   │   │   │   ├── AccountRepository.java
│   │   │   │   │   ├── TransactionRepository.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   ├── service/                           # Service interfaces (business logic)
│   │   │   │   │   ├── AccountService.java
│   │   │   │   │   ├── TransactionService.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   ├── exception/                         # Exception handling
│   │   │   │   │   ├── ApiExceptionHandler.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   │
│   │   │   │   │
│   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   ├── infrastructure/                        # Infrastructure layer
│   │   │   │   │   ├── adapter/                           # Adapters for external interfaces
│   │   │   │   │   │   ├── api/                           # API adapters
│   │   │   │   │   │   │   ├── RestAccountController.java
│   │   │   │   │   │   │   ├── RestTransactionController.java
│   │   │   │   │   │   │   └── ...
│   │   │   │   │   │   │
│   │   │   │   │   │   ├── persistence/                   # Persistence adapters
│   │   │   │   │   │   │   ├── JpaAccountRepository.java
│   │   │   │   │   │   │   ├── JpaTransactionRepository.java
│   │   │   │   │   │   │   └── ...
│   │   │   │   │   │   │
│   │   │   │   │   │   └── ...
│   │   │   │   │   │
│   │   │   │   │   ├── config/                            # Configuration classes
│   │   │   │   │   │   ├── AwsConfig.java
│   │   │   │   │   │   └── ...
│   │   │   │   │   │
│   │   │   │   │   ├── exception/                         # Exception handling
│   │   │   │   │   │   ├── ApiExceptionHandler.java
│   │   │   │   │   │   └── ...
│   │   │   │   │   │
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   └── ...
│   │   │   │
│   │   │   └── ...
│   │   │
│   │   └── resources/                                     # Resource files (e.g., application properties)
│   │       ├── application.properties
│   │       └── ...
│   │
│   └── test/                                                # Test sources
│       └── java/
│           └── com.example.gmoney/
│               └── ...
│
├── Dockerfile                                              # Dockerfile for containerization
├── docker-compose.yml                                      # Docker Compose file for local development
└── ...
│
│
├── config/                  # Configuration files (e.g., Spring Boot, AWS)
│   ├── application.yml
│   └── aws-config.yml
