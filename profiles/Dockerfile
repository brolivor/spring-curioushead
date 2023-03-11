FROM openjdk:21-slim
COPY /target/profiles*.jar /app/profiles.jar
ENTRYPOINT ["java", "-jar", "/app/profiles.jar"]