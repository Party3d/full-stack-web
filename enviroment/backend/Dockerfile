# Etapa 1: build com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagem leve com JAR
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

