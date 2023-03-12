FROM openjdk:21-slim
COPY /target/profiles*.jar /app/profiles.jar
ENTRYPOINT ["java", "-cp", "/app/profiles.jar", "-Dloader.main=com.curioushead.profiles.ProfilesRoot", "org.springframework.boot.loader.PropertiesLauncher"]