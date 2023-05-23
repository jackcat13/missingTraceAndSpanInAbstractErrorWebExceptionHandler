package com.example.springwebfluxhandlingexecptions;

import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

@Component
@Order(1)
public class TracingWebFilter implements WebFilter {

    Logger logger = LoggerFactory.getLogger(TracingWebFilter.class);

    @Autowired
    Tracer tracer;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        logger.info("Inside web filter: currentSpan: {}", tracer.currentSpan());
        return chain.filter(exchange);
    }

}
