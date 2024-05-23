package com.example.task14.controllers;

import com.example.task14.objects.Item;
import com.example.task14.objects.Order;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class ItemController {
    //private final OrderService orderService;
    private List<Item> items = new ArrayList<>();
    @RequestMapping(value="/item", method= RequestMethod.POST)
    public void create(@RequestBody Item item){
        items.add(item);
        System.out.println("Создан новый объект Item");
        System.out.println(item);
    }

    @RequestMapping(value="/item", method=RequestMethod.DELETE)
    public void delete(@RequestBody Item item){
        items.removeIf(o  -> (Objects.equals(o.getName(), item.getName())));
    }

    @RequestMapping(value="/item", method=RequestMethod.GET)
    public ResponseEntity<List<Item>> getAll(){
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
