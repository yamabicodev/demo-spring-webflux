package com.example.webflux.demowebflux.controller;

import com.example.webflux.demowebflux.request.MessageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
public class DemoController {

    @RequestMapping(value = "/hello-get-mono-controller", method = RequestMethod.GET)
    public Mono<String> getMono() {
        return Mono.just("hello-get-mono");
    }

    @RequestMapping(value = "/hello-get-flux-controller", method = RequestMethod.GET)
    public Flux<String> getFlux() {
        return Flux.just("hello-get-flux1", "hello-get-flux2");
    }

    //$ curl -XPOST -d '{"message":"test"}' -H "Content-Type: application/json" http://localhost:8080/message-post-router
    @RequestMapping(value = "/message-post-mono-controller", method = RequestMethod.POST)
    public Mono<String> postMono(@RequestBody MessageRequest request) {
        return Mono.just(String.format("[メッセージ]:%s [投稿時刻]:%s", request.getMessage(), LocalDateTime.now().toString()));
    }

    @GetMapping("/handler-mapping-test")
    public Mono<String> handlerMappingTest() {
        return Mono.just("handlerMappingTest-Controller");
    }
}
