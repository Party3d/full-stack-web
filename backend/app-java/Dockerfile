# Etapa 1: build com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagem leve com JAR
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/app-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-db.sh .
RUN apt-get update && apt-get install -y postgresql-client 
RUN chmod +x wait-for-db.sh
ENV DATABASE_HOST=postgres
ENV DATABASE_PORT=5432
ENV DATABASE_NAME=seubanco
ENV DATABASE_USER=seuusuario
ENV DATABASE_PASSWORD=suasenha
ENTRYPOINT ["./wait-for-db.sh", "java", "-jar", "app.jar"]

