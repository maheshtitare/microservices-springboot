FROM eclipse-temurin:17-jdk-alpine

RUN apk add --no-cache maven

WORKDIR /app

ENV SPRING_PROFILES_ACTIVE=default

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8761

CMD ["java", "-jar", "target/discovery-0.0.1-SNAPSHOT.jar"]
