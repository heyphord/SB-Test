# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-17-slim AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a lightweight base image for the final image
FROM openjdk:17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/demo-0.0.1.jar .

# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8080

# Set the command to run your application
CMD ["java", "-jar", "demo-0.0.1.jar"]

#build command
#docker build -t demo:v1 .

#run command
#docker run -d -p<HOST_PORT>:8080 <CUSTOM_CONTAINER_NAME> demo:v1