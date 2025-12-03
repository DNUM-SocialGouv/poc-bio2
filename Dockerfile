# --- Étape 1 : Construction (Build) ---
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

# Compilation pour générer le JAR
RUN mvn clean package -DskipTests

# --- Étape 2 : Exécution (Run) ---
# Utilisation d'une image JRE légère (Alpine)
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copie du JAR généré depuis l'étape de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]