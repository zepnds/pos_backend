#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests
#
#FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /target/pos_system-0.0.1-SNAPSHOT.jar pos_system.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar", "pos_system.jar"]

# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/pos_system-0.0.1-SNAPSHOT.jar pos_system.jar

# Expose the port on which the application will run
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "pos_system.jar"]