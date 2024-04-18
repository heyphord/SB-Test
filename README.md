# DEMO-MICROSERVICE
Boiler plate code to start a new microservice using java 17.

## DEFAULT SPRING LIBRARIES

- Lombok: Java annotation library which helps to reduce boilerplate code.

- Spring Boot DevTools: Provides fast application restarts, LiveReload, and configurations for enhanced development experience.

- Spring Web WEB :Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

- Spring Security SECURITY : Highly customizable authentication and access-control framework for Spring applications.

- Spring Data JPA SQL :Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

- MySQL Driver SQL:MySQL JDBC driver.

- Oracle Driver SQL :A JDBC driver that provides access to Oracle.

- PostgreSQL Driver SQL :A JDBC and R2DBC driver that allows Java programs to connect to a PostgreSQL database using standard, database independent Java code.

- Java Mail Sender I/O :Send email using Java Mail and Spring Framework's JavaMailSender.

- Resilience4J SPRING CLOUD CIRCUIT BREAKER :Spring Cloud Circuit breaker with Resilience4j as the underlying implementation.

## PROJECT FOLDER STRUCTURE
```md

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
│   │   │   │   │
│   │   │   │   ├── config/                             # Spring boot Configurations
│   │   │   │   │   ├── CorsConfig.java
│   │   │   │   │   ├── SecurityConfig.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   │
│   │   │   │   ├── controller/                        # Rest api Enpoints 
│   │   │   │   │   ├── AccountController.java
│   │   │   │   │   ├── TransactionController.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   │
│   │   │   │   ├── repository/                        # Repository interfaces (persistence)
│   │   │   │   │   ├── AccountRepository.java
│   │   │   │   │   ├── TransactionRepository.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   │
│   │   │   │   ├── dto/                               # Data transfer objects  (request and response object)
│   │   │   │   │   ├── AccountRequestDto.java
│   │   │   │   │   ├── AccountResponseDto.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   │
│   │   │   │   ├── service/                           # Service interfaces (business logic)
│   │   │   │   │   ├── AccountService.java
│   │   │   │   │   ├── TransactionService.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   │
│   │   │   │   ├── exception/                         # Exception handling
│   │   │   │   │   ├── ApiExceptionHandler.java
│   │   │   │   │   └── ...
│   │   │   │   │
│   │   │   │   │
│   │   │   │   └── ...
│   │   │   │
│   │   │   └── ...
│   │   │
│   │   └── resources/                                  # Resource files (e.g., application properties)
│   │       ├── application.properties
│   │       └── ...
│   │
│   └── test/                                           # Test sources
│       └── java/
│           └── com.gmfs.demo/
│               └── ...
│
├── buildspec.yml                                      # AWS Codebuild file for CICD
├── Dockerfile                                          # Dockerfile for containerization
├── docker-compose.yml                                  # Docker Compose file for local development
└── ...
│
│
├── kubernetes/                                         # Kubernetes manifest files 
│   ├── deployment.yml
│   └── service.yml
│
├── config/                                             # Configuration files (e.g., Spring Boot, AWS)
│   ├── application.yml
│   └── aws-config.yml
│
│
└── ...

```

## REST API GUIDELINES

Guide to how apis will designed for consistency accross microservices.

https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design

### Versioning 
Versioning in URL: /api/{version}/resource
Example: /api/v1/users


### Endpoint urls:

Endpoint naming convention: /api/{version}/resource/{id}/resource
Endpoint naming convention: /api/{version}/resource/{id}
Endpoint naming convention: /api/{version}/resource

Example 1: /api/v1/customers/1/orders
The preceding url can be used to find all the orders for customer 1

Example 2: /api/v1/customers/1/
The preceding url can be used to retrieve the details of customer with id 1


Example 3: /api/v1/customers
The preceding url can be used to fetch all customers or add a new customer depending on the HTTP method. See next section on HTTP methods.


### HTTP methods

- GET retrieves a representation of the resource at the specified URI. The body of the response message contains the details of the requested resource.

- POST creates a new resource at the specified URI. The body of the request message provides the details of the new resource. Note that POST can also be used to trigger operations that don't actually create resources.

- PUT either creates or replaces the resource at the specified URI. The body of the request message specifies the resource to be created or updated.

- DELETE removes the resource at the specified URI.

### Request and Response Format
Use JSON Schema for defining request and response structures. Use the appropriate HTTP status codes for each api response https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
- Request format: This will depend on the input for the endpoint. Make sure you declare a Request DTO for the api request in the src/main/java/com/gmfs/demo/dto folder

- Response format: All responses should have the format below
```
{
    message:"message to send to end user"
    data:"Response Dto goes here"
    code:"response code"
}
```
### Error Handling:

Standard error format (similar to response format above):

```
 {
    "code": 400,
    "message": "Bad Request",
    "data": null
}
```

Use appropriate HTTP status codes (e.g., 400 for client errors, 500 for server errors).
https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

### Security:

Authentication: AWS API gateway authentication
Authentication: Amazon Cognito
Authorization: Roles-based access control using spring security (e.g., admin, user)

Use HTTPS for secure communication.
Implement CORS policies to control cross-origin requests.
Input validation to prevent injection attacks.

### Documentation:

Use Postman/Swagger for interactive API documentation.
Document each endpoint with descriptions, request parameters, response formats, and examples.
Security:


### Testing:

Unit testing: JUnit for testing individual components.
Integration testing:MockMvc/RestAssured for integration tests

### Performance:

Caching: Use caching mechanisms to improve response times.
Pagination: Implement pagination for large data sets.
Database optimization: Optimize queries for better performance.

### Version Control and Deployment:

We will use Github for version control.

Will will use AWS CI/CD pipeline for code deployment to production and staging servers.

Continuous Integration/Continuous Deployment (CI/CD) pipeline for automated testing and deployment.
Rollback strategy for handling deployment failures.