FROM maven:3.8.5-openjdk-17 AS package
WORKDIR /app
COPY pom.xml .
COPY src/ ./src/
RUN mvn clean package -DskipTests=true

FROM openjdk:17-jdk-slim
COPY --from=package /app/target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]