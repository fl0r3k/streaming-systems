#!/bin/bash

properties_template=${KAFKA_HOME}/config/server.properties.template
properties_file=${KAFKA_HOME}/config/server.properties

python3 configure.py ${properties_template} ${properties_file}

kafka-server-start.sh $properties_file