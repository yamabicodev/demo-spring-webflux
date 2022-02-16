package com.example.webflux.demowebflux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class DemoRouter {

    @Bean
    RouterFunction<ServerResponse> routers(DemoHandler demoHandler,
                                           MemberHandler memberHandler) {
        //$ curl -XPOST -d '{"message":"test"}' -H "Content-Type: application/json" http://localhost:8080/message-post-router
        //$ curl http://localhost:8080/get-member
        //$ curl -XPOST -d '{}' -H "Content-Type: application/json" http://localhost:8080/register-member
        //$ curl -XDELETE -d '{}' -H "Content-Type: application/json" http://localhost:8080/delete-member
        return RouterFunctions.route()
                .GET("/hello-get-router", demoHandler::getHello)
                .POST("/message-post-router", demoHandler::postMessage)
                .add(memberHandler.memberRoutes()) //ルーティングごとHandlerに委譲
                .build();
    }

    @Bean
    RouterFunction<ServerResponse> handlerMappingTest() {
        return RouterFunctions.route()
                .GET("handler-mapping-test", request -> ServerResponse.ok().body(Mono.just("handlerMappingTest-Router"), String.class))
                .build();
    }
}
