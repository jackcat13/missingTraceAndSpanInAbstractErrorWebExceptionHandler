package com.example.springwebfluxhandlingexecptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class SpringWebfluxHandlingExecptionsApplication {

    public SpringWebfluxHandlingExecptionsApplication() {
        Hooks.enableAutomaticContextPropagation();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxHandlingExecptionsApplication.class, args);
    }

}
