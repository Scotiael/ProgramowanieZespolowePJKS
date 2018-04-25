package com.programowanie.zespolowe.pz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld  {

    @RequestMapping("/pz")
    public String hello(){
        return "Hello World";
    }
}
