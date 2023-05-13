FROM openjdk:17
EXPOSE 8080
WORKDIR /app
COPY target/WarMedicApp-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar", "/app/WarMedicApp-0.0.1-SNAPSHOT.jar"]