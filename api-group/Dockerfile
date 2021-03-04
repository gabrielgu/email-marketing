FROM maven:3.6.3-jdk-11 AS maven_build

COPY ./ /api-group

WORKDIR /api-group

RUN mvn clean package

FROM openjdk:11-jre-buster

COPY --from=maven_build /api-group/target/api-group-0.0.1-SNAPSHOT.jar /api-group.jar

CMD ["java", "-jar", "/api-group.jar"]