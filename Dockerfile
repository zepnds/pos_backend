FROM openjdk-17
EXPOSE 8080
ADD target/pos_system-0.0.1-SNAPSHOT.jar pos_system.jar
ENTRYPOINT ["java","-jar","pos_system.jar"]