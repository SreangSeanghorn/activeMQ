package com.example.day01_jms.Service.Implementation;

import com.example.day01_jms.DataEntities.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.TextMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {
    @Autowired
    JmsTemplate jmsTemplate;
    public void sendMessageToQueueWithObjectBook(Book book){
        try {
            String jsonObj = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(book);
            jmsTemplate.convertAndSend("testQueue", jsonObj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
