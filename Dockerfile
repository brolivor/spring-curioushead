FROM openjdk:19-alpine as builder
RUN mkdir -p /opt/sources
COPY . /opt/sources
WORKDIR /opt/sources

FROM builder
COPY --from=builder /opt/sources/miscellaneous/target/*.jar miscellaneous.jar
ENTRYPOINT ["java", "-jar", "/miscellaneous.jar"]

FROM builder
COPY --from=builder /opt/sources/profiles/target/*.jar profiles.jar
ENTRYPOINT ["java", "-jar", "/profiles.jar"]