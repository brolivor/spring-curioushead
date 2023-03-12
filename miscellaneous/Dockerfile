FROM openjdk:21-slim
COPY /target/miscellaneous*.jar /app/miscellaneous.jar
ENTRYPOINT ["java", "-cp", "/app/miscellaneous.jar", "-Dloader.main=com.curioushead.miscellaneous.MiscellaneousRoot", "org.springframework.boot.loader.PropertiesLauncher"]