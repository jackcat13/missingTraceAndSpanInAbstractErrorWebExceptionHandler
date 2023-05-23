package com.example.springwebfluxhandlingexecptions.controller;

import com.example.springwebfluxhandlingexecptions.exception.UnAuthorizedException;
import com.example.springwebfluxhandlingexecptions.model.Book;
import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class lBookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    Tracer tracer;

    @GetMapping("/book")
    public Mono<ResponseEntity<Book>> getBookById() {
        logger.info("Inside Controller currentSpan: {} ", tracer.currentSpan());
        return Mono.error(new UnAuthorizedException("Access denied"));
    }

    @GetMapping("/books")
    public Mono<ResponseEntity<List<Book>>> getBooks() {
        logger.info("Inside Controller currentSpan: {} ", tracer.currentSpan());
        return Mono.just(ResponseEntity.ok(List.of(new Book("1", "Eng"))));
    }

}
