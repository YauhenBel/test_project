FROM gradle:jdk17

RUN set -x \
    mkdir -p /app

ENV LANG C.UTF-8

COPY bin/test_project.tar resources/logback.xml /app/
COPY resources /app/resources

WORKDIR /app

EXPOSE 8080
RUN tar -C /tmp -xvf test_project.tar && \
    mkdir /app/test-project-api && \
    mkdir /app/test-project-api/lib && \
    mkdir /app/test-project-api/bin && \
    mv /tmp/test_project*/lib/* /app/test-project-api/lib/ && \
    mv /tmp/test_project*/bin/* /app/test-project-api/bin/
WORKDIR /app/test-project-api
ENV TEST_PROJECT_OPTS="-Dlogback.configurationFile=/app/logback.xml"
CMD bin/test_project