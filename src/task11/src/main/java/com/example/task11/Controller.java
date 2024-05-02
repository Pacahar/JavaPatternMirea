package com.example.task11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String checkHealth() {
        return "Application is up and running!";
    }
}
