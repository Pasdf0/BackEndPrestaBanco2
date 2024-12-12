FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} follow-up-service.jar
ENTRYPOINT ["java","-jar","/follow-up-service.jar"]