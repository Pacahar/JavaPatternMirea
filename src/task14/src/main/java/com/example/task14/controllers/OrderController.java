package com.example.task14.controllers;

import com.example.task14.objects.Order;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class OrderController {

    //private final OrderService orderService;
    private List<Order> orders = new ArrayList<>();
    @RequestMapping(value="/order", method=RequestMethod.POST)
    public void create(@RequestBody Order order){
        orders.add(order);
        System.out.println("Создан новый объект Order");
        System.out.println(order);
    }

    @RequestMapping(value="/order", method=RequestMethod.DELETE)
    public void delete(@RequestBody Order order){
        orders.removeIf(o  -> (Objects.equals(o.getOrderDate(), order.getOrderDate())));
    }

    @RequestMapping(value="/order", method=RequestMethod.GET)
    public ResponseEntity<List<Order>> getAll(){
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
