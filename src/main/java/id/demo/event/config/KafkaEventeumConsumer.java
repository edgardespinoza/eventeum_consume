package id.demo.event.config;

import java.io.IOException;

import com.google.gson.Gson;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.consensys.eventeum.dto.event.ContractEventDetails;
import net.consensys.eventeum.dto.message.EventeumMessage;

@Slf4j
@Service
public class KafkaEventeumConsumer {



     @KafkaListener(
            topics = "#{'${app.kafka.consumer.topic}'}",
            groupId = "#{'${spring.kafka.consumer.group-id}'}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeContractEvent(EventeumMessage<ContractEventDetails> message, Acknowledgment acknowledgment)
            throws IOException {
        final ContractEventDetails contractEventDetails = message.getDetails();
        
        log.info("event:: {}", new Gson().toJson(contractEventDetails)); 

     
       acknowledgment.acknowledge();
    }

}
