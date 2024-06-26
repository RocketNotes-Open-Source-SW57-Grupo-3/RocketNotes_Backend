package com.fivestars.rocketnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RocketnotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketnotesApplication.class, args);
    }

}
