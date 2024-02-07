FROM amazoncorretto:17.0.10

WORKDIR /app

COPY /target/myexpenses-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]