package com.dizstance.messageconsumer.controller;

import com.dizstance.messageconsumer.model.MessageDTO;
import com.dizstance.messageconsumer.service.MessageConsumerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/consumer")
public class MessageConsumerController {

    private final MessageConsumerService messageConsumerService;

    public MessageConsumerController(MessageConsumerService messageConsumerService) {
        this.messageConsumerService = messageConsumerService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MessageDTO> initProcess(){
        return messageConsumerService.transformMessage();
    }
}
