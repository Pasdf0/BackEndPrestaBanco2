FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} evaluate-service.jar
ENTRYPOINT ["java","-jar","/evaluate-service.jar"]