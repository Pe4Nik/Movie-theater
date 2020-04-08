FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} movie-service.jar
CMD java -jar /movie-service.jar