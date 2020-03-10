FROM openjdk:latest
COPY ./target/semGroupProject.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semGroupProject.jar", "db:3306"]