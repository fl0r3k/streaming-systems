import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class BasicProducer {

    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","localhost:9092");
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer producer = new KafkaProducer<String,String>(kafkaProps);

        ProducerRecord record = new ProducerRecord(
                "someTopic",
                "someKey",
                "someMessage"
        );

        try {
            System.out.println("Sending record ...");
            producer.send(record);
            System.out.println("Record sent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}