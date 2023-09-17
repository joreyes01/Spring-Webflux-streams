package com.dizstance.messageconsumer.service;

import com.dizstance.messageconsumer.model.MessageDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class MessageConsumerService {
    private final WebClient.Builder webClient;

    public MessageConsumerService(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    public Flux<MessageDTO> transformMessage () {

        return webClient.build()
                .get()
                .uri("/producer")
                .retrieve()
                .bodyToFlux(MessageDTO.class)
                .doOnNext(messageDTO -> {
                    System.out.println(saveData(messageDTO.getMessage()));
                });
//                .doFinally(message -> {
//                    System.out.println("Finally : " +message.toString());
//                });
    }

    private String saveData (String message) {
        return "Data saved : " + message;
    }
}
