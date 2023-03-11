package com.curioushead.miscellaneous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.curioushead.miscellaneous.repositories")
public class MiscellaneousRoot {
    public static void main(String[] args) {
        SpringApplication.run(MiscellaneousRoot.class, args);
    }
}
