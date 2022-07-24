FROM openjdk:12-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
RUN ls .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]