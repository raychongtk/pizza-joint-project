FROM openjdk:15-jdk-alpine
COPY build/libs/pizza-api-1.0.0.jar pizza-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/pizza-api.jar"]
