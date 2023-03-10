FROM openjdk:19-alpine as builder
RUN mkdir -p /opt/sources
COPY . /opt/sources
WORKDIR /opt/sources

FROM builder
COPY --from=builder /opt/sources/profiles/target/*.jar profiles.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "/profiles.jar"]

FROM builder
COPY --from=builder /opt/sources/miscellaneous/target/*.jar miscellaneous.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "/miscellaneous.jar"]