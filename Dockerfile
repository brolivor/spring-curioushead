FROM openjdk:19-alpine
WORKDIR /opt/docker_images
ARG JAR_FILE=profiles/target/profiles-*.jar
COPY ${JAR_FILE} /curioushead-projects.jar
ENTRYPOINT ["java", "-jar", "/curioushead-projects.jar"]