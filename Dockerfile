FROM openjdk:20-ea-11-slim
WORKDIR /app
COPY target/super-kassa-0.0.1-SNAPSHOT.jar service.jar
ENTRYPOINT ["java", "-jar", "./service.jar"]
CMD ["noname"]
EXPOSE 8000