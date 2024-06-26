package com.example.task14.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    @GetMapping("/home")
    public String home(Model model) {
        return "index.html";
    }

    @GetMapping("/")
    public String main(Model model) {
        return "index.html";
    }
}