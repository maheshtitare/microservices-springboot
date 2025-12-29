# Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

# App working directory
WORKDIR /app

# FORCE native profile
ENV SPRING_PROFILES_ACTIVE=native

# Copy project files
COPY . .

# Build application using system maven
RUN mvn clean package -DskipTests

# Expose Config Server port
EXPOSE 8888

# Run the application
CMD ["java", "-jar", "target/config-server-0.0.1-SNAPSHOT.jar"]
