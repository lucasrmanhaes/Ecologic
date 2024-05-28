FROM eclipse-temurin:21-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/ecologic-1.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
LABEL authors="Créditos: Lucas, Rubens, Rita, Raiane e Nathaly"