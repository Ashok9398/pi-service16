FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY /build/libs/Piservice-0.0.1-SNAPSHOT.jar /app/application.jar

COPY chunks/ /app/chunks/

EXPOSE 8080

CMD ["java", "-Dspring-boot.run.arguments=--chunk.file=${CHUNK_FILE}", "-jar", "application.jar"]
