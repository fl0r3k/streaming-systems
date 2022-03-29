package com.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class SimpleProducer {

    private static final Logger log = LoggerFactory.getLogger(SimpleProducer.class.getSimpleName());

    public static void main(String[] args) {
        log.info("Kafka Producer");

        String bootstrapServers = "127.0.0.1:19092,127.0.0.1:29092,127.0.0.1:39092";

        // define producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        // create producer
        KafkaProducer<String,String> producer = new KafkaProducer<>(properties);

        // create a producer record
        ProducerRecord<String,String> producerRecord = new ProducerRecord<>("java_example","hello world");

        // send the data
        // asynchronous (fire-and-forget)
        producer.send(producerRecord);

        // flush data
        producer.flush();

        // flush data and close producer
        producer.close();

    }
}

