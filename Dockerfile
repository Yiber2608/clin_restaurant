FROM openjdk:21-jdk
ARG JAR_FILE=target/ApiRestSB-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} java-app.jar
EXPOSE 8080
CMD ["java", "-jar", "java-app.jar"]
