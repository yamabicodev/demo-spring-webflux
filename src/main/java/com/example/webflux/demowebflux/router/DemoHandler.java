package com.example.webflux.demowebflux.router;

import com.example.webflux.demowebflux.request.MessageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class DemoHandler {

    public Mono<ServerResponse> getHello(ServerRequest request) {
            return ServerResponse
                    .ok()
                    .body(Mono.just("HelloGetRouter"), String.class);
    }

    public Mono<ServerResponse> postMessage(ServerRequest request) {
        var monoMessageRequest = request.bodyToMono(MessageRequest.class);
        return monoMessageRequest
                .flatMap(messageRequest -> {
                            var response = Mono.just(String.format("[メッセージ]:%s [投稿時刻]:%s", messageRequest.getMessage(), LocalDateTime.now().toString()));
                            return  ServerResponse
                                    .ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .body(response, String.class);
                });
    }
}
