FROM fl0r3k/streaming-base

ARG kafka_version=3.0.0
ARG scala_version=2.13
ARG kafka_home=/usr/local/kafka
ARG kafka_archive_name=kafka_${scala_version}-${kafka_version}

RUN wget -P /tmp/ https://archive.apache.org/dist/kafka/${kafka_version}/kafka_${scala_version}-${kafka_version}.tgz && \
    tar -zvxf /tmp/kafka_${scala_version}-${kafka_version}.tgz -C /tmp && \
    mv /tmp/kafka_${scala_version}-${kafka_version} ${kafka_home} && \
    mkdir /tmp/kafka-logs

ENV KAFKA_VERSION=${kafka_version} \
    KAFKA_HOME=${kafka_home}

ENV PATH=${PATH}:${KAFKA_HOME}/bin

EXPOSE 9092

COPY server.properties.template ${kafka_home}/config
COPY start.sh .

ENTRYPOINT ["./start.sh"]