FROM openjdk:19-alpine
WORKDIR /opt/docker_images
ARG JAR_FILE=target/curioushead-*.jar
COPY ${JAR_FILE} /curioushead-root-project.jar
ENTRYPOINT ["java", "-jar", "/curioushead-root-project.jar"]