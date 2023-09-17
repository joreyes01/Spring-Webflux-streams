package com.dizstance.messageproducer.service;


import com.dizstance.messageproducer.model.MessageDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class MessageProducerService {

    public Flux<MessageDTO> getMessages (){
        return Flux
                .just(new MessageDTO("Message 1"),
                        new MessageDTO("Message 2"),
                        new MessageDTO("Message 3"))
                .delayElements(Duration.ofSeconds(3));
    }
}
