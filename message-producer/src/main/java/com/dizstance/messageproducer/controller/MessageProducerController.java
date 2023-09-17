package com.dizstance.messageproducer.controller;

import com.dizstance.messageproducer.model.MessageDTO;
import com.dizstance.messageproducer.service.MessageProducerService;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/producer")
public class MessageProducerController {
    private final MessageProducerService messageProducerService;

    public MessageProducerController(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    //@GetMapping // Returning data after 9 secs
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE) // Returning data every 3 secs
    public Flux<MessageDTO> getMessages (){
        return messageProducerService.getMessages();
    }
}
