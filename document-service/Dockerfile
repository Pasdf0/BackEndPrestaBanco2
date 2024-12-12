FROM openjdk:21
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} document-service.jar
ENTRYPOINT ["java","-jar","/document-service.jar"]