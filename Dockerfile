FROM openjdk:latest
COPY ./target/semGroupProject-0.1.0.3-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semGroupProject-0.1.0.3-jar-with-dependencies.jar"]