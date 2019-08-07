package com.dependencyInjectiondemo.controllers;

import services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {
    private GreetingService greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }

    @Autowired
    //ili dodati unutar argumenata metode
    @Qualifier("setterGreetingService")
    public void setGreetingService(GreetingService greetingService){
        this.greetingService=greetingService;
    }
}
