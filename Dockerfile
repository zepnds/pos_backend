# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests
RUN ls -la /app/target  # List files to confirm the JAR is present

# Stage 2: Run the application
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /app/target/pos_system-0.0.1-SNAPSHOT.jar pos_system.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pos_system.jar"]
