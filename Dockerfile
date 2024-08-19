#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests
#
#FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /target/pos_system-0.0.1-SNAPSHOT.jar pos_system.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar", "pos_system.jar"]

# Use the official OpenJDK image as the base image
FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-alpine
COPY --from=build /target/pos_system-0.0.1-SNAPSHOT.jar pos_system.jar
ENTRYPOINT ["java","-Dspring.profiles.active=render","-jar","pos_system.jar"]