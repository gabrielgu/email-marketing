FROM maven:3.6.3-jdk-11 AS maven_build

COPY ./ /api-contact

WORKDIR /api-contact

RUN mvn clean package

FROM openjdk:11-jre-buster

COPY --from=maven_build /api-contact/target/api-contact-0.0.1-SNAPSHOT.jar /api-contact.jar

CMD ["java", "-jar", "/api-contact.jar"]