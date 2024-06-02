package com.example.task21.controllers;

import com.example.task21.DTO.ItemDTO;
import com.example.task21.objects.Item;
import com.example.task21.services.EmailService;
import com.example.task21.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;
    @Autowired
    private EmailService emailService;
    @RequestMapping(value="/item", method= RequestMethod.POST)
    public ResponseEntity<Item> create(@RequestBody ItemDTO dto){
        emailService.sendSimpleMessage("Item created", dto.getName() + " was created", "s.kirill29@yandex.ru");
        return new ResponseEntity<>(itemService.create(dto), HttpStatus.OK);
    }

    @RequestMapping(value="/item", method=RequestMethod.DELETE)
    public void delete(@RequestParam Long id){
        itemService.delete(id);
    }

    @RequestMapping(value="/item", method=RequestMethod.GET)
    public ResponseEntity<List<Item>> readAll() {
        return new ResponseEntity<>(itemService.readAll(), HttpStatus.OK);
    }
}
