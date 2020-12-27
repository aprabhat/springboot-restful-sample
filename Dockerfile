FROM openjdk:8-jdk-alpine
LABEL aprabhat <prabhat.agarwal0605@gmail.com>
COPY build/libs/springboot-restful-sample-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]