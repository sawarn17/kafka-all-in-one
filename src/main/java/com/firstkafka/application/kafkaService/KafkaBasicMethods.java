package com.firstkafka.application.kafkaService;


import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.stereotype.Service;

@Service
public class KafkaBasicMethods {

    public NewTopic createPartition(String partitionName, int partitionCount){
        return new NewTopic(partitionName, partitionCount, (short) 1);
    }
}
