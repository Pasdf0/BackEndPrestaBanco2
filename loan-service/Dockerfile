FROM openjdk:21
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} loan-service.jar
ENTRYPOINT ["java","-jar","/loan-service.jar"]