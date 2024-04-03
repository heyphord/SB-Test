# Use a base image with Java 22 installed
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file into the container
COPY target/your-application.jar app.jar

# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]