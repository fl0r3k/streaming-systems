#!/bin/bash

config_template=${ZOOKEEPER_HOME}/conf/zoo.cfg.template
config_file=${ZOOKEEPER_HOME}/conf/zoo.cfg

python3 configure.py ${config_template} ${config_file}

echo ${ZOOKEEPER_SERVER_ID} > ${ZOOKEEPER_DATA_DIR}/myid

zkServer.sh start-foreground