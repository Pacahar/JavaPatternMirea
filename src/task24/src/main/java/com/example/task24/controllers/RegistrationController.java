package com.example.task24.controllers;

import com.example.task24.DTO.UserDTO;
import com.example.task24.objects.AppUser;
import com.example.task24.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registration(Model model) {
        return "reg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ResponseEntity<AppUser> create(@RequestParam String name, @RequestParam String email,
                                          @RequestParam String password,
                                          Model model) {
        UserDTO dto = new UserDTO(name, password, email, "USER");
        return new ResponseEntity<>(userService.addUser(dto), HttpStatus.OK);
    }
}
