package com.programowanie.zespolowe.pz;

import com.programowanie.zespolowe.pz.dao.UserDAO;
import com.programowanie.zespolowe.pz.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.programowanie.zespolowe.pz.dao")
@EntityScan("com.programowanie.zespolowe.pz.entities")
public class PzApplication implements CommandLineRunner {

    Logger log = LoggerFactory.getLogger(PzApplication.class);

    @Autowired
    UserDAO userDAO;
    public static void main(String[] args) {
        SpringApplication.run(PzApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("test");
        user.setName("test");
        user.setPassword("test");
        user.setSurname("test");
        log.info(userDAO.findAll().toString());
    }
}
