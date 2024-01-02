package com.firstkafka.application.serviceImpl;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EventProducer {

    @Autowired KafkaTemplate<String, Object> kafkaTemplate;

    public void publishMessage(String message) {
        CompletableFuture<SendResult<String, Object>> send = kafkaTemplate.send("ayam-first-message-topic", message);
        send.whenComplete((result, ex) ->{
            if(ex == null){
                System.out.println("the message is sucessfully published ::::::::::"+ result.getRecordMetadata());
            }else {
                System.out.println("we are facing issue while producing the result ::::::::::::::::::::"+ ex.getStackTrace());
            }
        });
    }
}
