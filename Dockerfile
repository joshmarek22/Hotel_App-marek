FROM eclipse-temurin:17-jdk-jammy

LABEL authors="Joshua Marek"

COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar /app/myApp.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/myApp.jar"]