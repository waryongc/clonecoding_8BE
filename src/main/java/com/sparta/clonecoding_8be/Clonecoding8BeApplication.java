package com.sparta.clonecoding_8be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class Clonecoding8BeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Clonecoding8BeApplication.class, args);
    }

}
