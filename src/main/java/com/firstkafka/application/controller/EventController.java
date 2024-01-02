package com.firstkafka.application.controller;

import com.firstkafka.application.serviceImpl.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    EventProducer eventProducer;

    @GetMapping("/publish/{message}")
    public ResponseEntity<Object> producedMessage(@PathVariable String message){
        eventProducer.publishMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
