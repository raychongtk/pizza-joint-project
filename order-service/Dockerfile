FROM openjdk:15-jdk-alpine
COPY build/libs/order-service-1.0.0.jar order-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/order-service.jar"]
