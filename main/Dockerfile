# Backend Dockerfile
# Step 1: Build the Spring Boot app
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the entire source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Run the app with OpenJDK
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the generated JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
