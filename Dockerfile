FROM openjdk:19-alpine as builder
WORKDIR /app
ADD . /app

FROM builder
COPY --from=builder /app/profiles/target/*.jar /app/profiles.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "/app/profiles.jar"]

FROM builder
COPY --from=builder /opt/sources/miscellaneous/target/*.jar /app/miscellaneous.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "/app/miscellaneous.jar"]