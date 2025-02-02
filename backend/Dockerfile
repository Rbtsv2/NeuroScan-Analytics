# Étape 1 : Construction de l'application
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Exécution de l'application
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/neuroscan.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
