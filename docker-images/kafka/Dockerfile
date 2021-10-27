FROM openjdk:11

ARG kafka_version=3.0.0
ARG scala_version=2.13
ARG kafka_home=/usr/local/kafka

RUN wget -P /tmp/ https://dlcdn.apache.org/kafka/${kafka_version}/kafka_${scala_version}-${kafka_version}.tgz && \
    tar -zvxf /tmp/kafka_${scala_version}-${kafka_version}.tgz && \
    mv /tmp/kafka_${scala_version}-${kafka_version}.tgz ${kafka_home} && \
    mkdir /tmp/kafka-logs

ENV KAFKA_VERSION=${kafka_version} \
    SCALA_VERSION=${scala_version} \
    KAFKA_HOME=${kafka_home}

ENV PATH=${PATH}:${KAFKA_HOME}/bin

