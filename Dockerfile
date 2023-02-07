FROM openjdk:19-alpine
WORKDIR /opt/docker_images
ARG JAR_FILE=target/api-*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]