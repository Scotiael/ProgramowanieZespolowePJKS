package com.programowanie.zespolowe.pz.controllers;

import com.programowanie.zespolowe.pz.dao.UserDAO;
import com.programowanie.zespolowe.pz.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld  {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/pz")
    public String hello(){
        User user = new User();
        user.setSurname("test");
        user.setName("test");
        user.setPassword("test");
        user.setEmail("test");
        userDAO.save(user);
        return "Hello World";
    }
}
