FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-alpine
COPY --from=build /target/rest-api-template-0.0.1-SNAPSHOT.jar pos_system.jar
ENTRYPOINT ["java","-Dspring.profiles.active=render","-jar","pos_system.jar"]