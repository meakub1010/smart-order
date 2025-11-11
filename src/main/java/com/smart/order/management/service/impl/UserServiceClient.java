package com.smart.order.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class UserServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    private final WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

    public String getUserInfo(String id){
        String url = "https://jsonplaceholder.typicode.com/todos/"+id;
        return restTemplate.getForObject(url, String.class);
    }

    public Mono<String> getUserInfoByWebClient(String id){
        return webClient.get().uri("/todos/{id}", id)
        .retrieve()
        .bodyToMono(String.class);
    }
}
