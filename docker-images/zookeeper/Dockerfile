FROM fl0r3k/streaming-base

ARG zookeeper_version=3.4.6
ARG zookeeper_home=/usr/local/zookeeper

RUN wget -P /tmp/ https://archive.apache.org/dist/zookeeper/zookeeper-${zookeeper_version}/zookeeper-${zookeeper_version}.tar.gz && \
    tar -zvxf /tmp/zookeeper-${zookeeper_version}.tar.gz -C /tmp && \
    mv /tmp/zookeeper-${zookeeper_version} ${zookeeper_home} && \
    mkdir -p /var/lib/zookeeper/data /var/lib/zookeeper/log && \
    rm -rf /tmp/*


ENV ZOOKEEPER_VERSION=${zookeeper_version} \
    ZOOKEEPER_HOME=${zookeeper_home}

ENV PATH=${PATH}:${ZOOKEEPER_HOME}/bin


EXPOSE 2181

VOLUME ["/var/lib/zookeeper/data"]

COPY zoo.cfg.template ${zookeeper_home}/conf
COPY start.sh .

ENTRYPOINT ["./start.sh"]