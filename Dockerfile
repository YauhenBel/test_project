FROM gradle:jdk17 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build


FROM openjdk:17 as backend
RUN set -x \
    mkdir -p /app
COPY . /app
EXPOSE 8080
WORKDIR /app
CMD ["java", "-jar", "test_project.jar"]