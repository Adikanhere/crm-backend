# Use OpenJDK 22
FROM openjdk:22-jdk-slim

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the project using Maven wrapper
RUN ./mvnw clean install -DskipTests

# Run the Spring Boot application
CMD ["java", "-jar", "target/rest-demo.jar"]
