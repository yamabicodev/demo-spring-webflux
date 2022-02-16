package com.example.webflux.demowebflux.router;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class MemberHandler {
    public RouterFunction<ServerResponse> memberRoutes() {
        return RouterFunctions.route()
                .GET("/get-member", this::getMember)
                .POST("/register-member", this::registerMember)
                .DELETE("/delete-member", this::deleteMember)
                .build();
    }

    private Mono<ServerResponse> getMember(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("unimplemented-getMember"), String.class);
    }

    private Mono<ServerResponse> registerMember(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("unimplemented-registerMember"), String.class);
    }

    private Mono<ServerResponse> deleteMember(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("unimplemented-deleteMember"), String.class);
    }
}
