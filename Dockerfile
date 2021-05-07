FROM adoptopenjdk/openjdk11:alpine

WORKDIR /app

COPY target/money-api-0.0.1-SNAPSHOT.jar /app/api.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "api.jar"]