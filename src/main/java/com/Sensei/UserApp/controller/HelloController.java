package com.Sensei.UserApp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @Value("${welcome.message}")
    private String welcomeMessage = "Connected to Database";
    @GetMapping("/")
    public String helloWorld(){
        return welcomeMessage;
    }
}
