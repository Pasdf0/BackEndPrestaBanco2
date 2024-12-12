FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} simulate-service.jar
ENTRYPOINT ["java","-jar","/simulate-service.jar"]