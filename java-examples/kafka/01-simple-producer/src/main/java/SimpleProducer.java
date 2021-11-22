import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class SimpleProducer {

    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);
        
        ProducerRecord<String, String> record = new ProducerRecord<>(
                "SomeTopic",
                "My Key",
                "My Message"
        );

        // Fire-and-Forget
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Synchronous send
        try {
            producer.send(record).get();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Asynchronous send
        class SimpleProducerCallback implements Callback {

            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e != null) {
                    e.printStackTrace();
                }
            }
        }

        try {
            producer.send(record, new SimpleProducerCallback());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}