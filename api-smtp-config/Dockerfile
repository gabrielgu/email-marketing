FROM maven:3.6.3-jdk-11 AS maven_build

COPY ./ /api-smtp-config

WORKDIR /api-smtp-config

RUN mvn clean package

FROM openjdk:11-jre-buster

COPY --from=maven_build /api-smtp-config/target/api-smtp-config-0.0.1-SNAPSHOT.jar /api-smtp-config.jar

CMD ["java", "-jar", "/api-smtp-config.jar"]