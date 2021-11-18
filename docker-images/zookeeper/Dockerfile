FROM fl0r3k/streaming-base

ARG zookeeper_version=3.6.3
ARG zookeeper_home=/usr/local/zookeeper
ARG zookeeper_archive_name=apache-zookeeper-${zookeeper_version}-bin
ARG zookeeper_data_dir=/var/lib/zookeeper/data

RUN wget -P /tmp/ https://archive.apache.org/dist/zookeeper/zookeeper-${zookeeper_version}/${zookeeper_archive_name}.tar.gz && \
    tar -zvxf /tmp/${zookeeper_archive_name}.tar.gz -C /tmp && \
    mv /tmp/${zookeeper_archive_name} ${zookeeper_home} && \
    mkdir -p ${zookeeper_data_dir} /var/lib/zookeeper/log && \
    rm -rf /tmp/*


ENV ZOOKEEPER_VERSION=${zookeeper_version} \
    ZOOKEEPER_HOME=${zookeeper_home} \
    ZOOKEEPER_DATA_DIR=${zookeeper_data_dir} \
    ZOOKEEPER_SERVER_ID=1

ENV PATH=${PATH}:${ZOOKEEPER_HOME}/bin


EXPOSE 2181 2888 3888

VOLUME ["${zookeeper_data_dir}","/var/lib/zookeeper/log"]

COPY zoo.cfg.template ${zookeeper_home}/conf
COPY start.sh .

ENTRYPOINT ["./start.sh"]