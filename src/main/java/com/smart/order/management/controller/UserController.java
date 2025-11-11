package com.smart.order.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.order.management.service.impl.UserServiceClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceClient userService;

    public UserController(UserServiceClient userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id){
        return userService.getUserInfo(id);
    }
    
    @GetMapping("/web/{id}")
    public Mono<String> getUserInfoByWebClient(@PathVariable String id){
        return userService.getUserInfoByWebClient(id);
    }
}
