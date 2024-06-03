package com.example.task24.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
        return "index.html";
    }
}