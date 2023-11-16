package com.joaquimFelix.ODSU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home"; // Thymeleaf resolverá isso como src/main/resources/templates/home.html
    }
}

