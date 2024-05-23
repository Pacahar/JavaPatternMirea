package com.example.task15.controllers;

import com.example.task15.DTO.OrderDTO;
import com.example.task15.objects.Order;
import com.example.task15.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @RequestMapping(value="/order", method= RequestMethod.POST)
    public ResponseEntity<Order> create(@RequestBody OrderDTO dto){
        return new ResponseEntity<>(orderService.create(dto), HttpStatus.OK);
    }

    @RequestMapping(value="/order", method=RequestMethod.DELETE)
    public void delete(@RequestParam Long id){
        orderService.delete(id);
    }

    @RequestMapping(value="/order", method=RequestMethod.GET)
    public ResponseEntity<List<Order>> readAll() {
        return new ResponseEntity<>(orderService.readAll(), HttpStatus.OK);
    }
}
