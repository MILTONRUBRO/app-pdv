# Etapa 1: Construir o projeto
FROM maven:3.8.6-eclipse-temurin-17-alpine AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Executar o Maven para construir o projeto e gerar o JAR
RUN mvn clean package -DskipTests

# Etapa 2: Executar a aplicação
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar o JAR gerado pela etapa de construção para o contêiner final
COPY --from=build /app/target/pdv-0.0.1.jar /app/app.jar

EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]