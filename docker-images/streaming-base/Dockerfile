FROM debian:stable-slim

RUN apt update && \
    apt upgrade -y && \
    apt install -y wget procps openjdk-11-jdk python3 python3-jinja2

ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ENV PATH=${PATH}:${JAVA_HOME}/bin

COPY configure.py .

CMD ["/bin/bash"]