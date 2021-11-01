#!/bin/bash

config_template=${ZOOKEEPER_HOME}/conf/zoo.cfg.template
config_file=${ZOOKEEPER_HOME}/conf/zoo.cfg

python3 configure.py ${config_template} ${config_file}

zkServer.sh start-foreground