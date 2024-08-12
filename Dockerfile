FROM openjdk:17-jdk-alpine
ARG JAR_FILE=targer/*jar
COPY ./target/pdv-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]