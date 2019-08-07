package com.dependencyInjectiondemo.controllers;

import services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    @Qualifier("greetingServiceImpl")
    private GreetingServiceImpl greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }

}
