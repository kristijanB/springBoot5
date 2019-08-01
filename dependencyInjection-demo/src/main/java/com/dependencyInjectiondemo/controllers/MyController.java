package com.dependencyInjectiondemo.controllers;

import com.dependencyInjectiondemo.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello(){
        System.out.println("HEllo! ");

        return greetingService.sayGreeting();
    }
}
