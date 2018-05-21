package com.programowanie.zespolowe.pz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.programowanie.zespolowe.pz.dao")
@EntityScan("com.programowanie.zespolowe.pz.entities")
public class PzApplication {

    Logger log = LoggerFactory.getLogger(PzApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PzApplication.class, args);
    }
}
