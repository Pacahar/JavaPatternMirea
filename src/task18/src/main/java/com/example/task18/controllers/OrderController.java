package com.example.task18.controllers;

import com.example.task18.DTO.OrderDTO;
import com.example.task18.objects.OrderO;
import com.example.task18.services.OrderService;
import lombok.AllArgsConstructor;
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
public class OrderController {

    private final OrderService orderService;
    @RequestMapping(value="/order", method= RequestMethod.POST)
    public ResponseEntity<OrderO> create(@RequestBody OrderDTO dto){
        return new ResponseEntity<>(orderService.create(dto), HttpStatus.OK);
    }

    @RequestMapping(value="/order", method=RequestMethod.DELETE)
    public void delete(@RequestParam Long id){
        orderService.delete(id);
    }

    @RequestMapping(value="/order", method=RequestMethod.GET)
    public ResponseEntity<List<OrderO>> readAll() {
        return new ResponseEntity<>(orderService.readAll(), HttpStatus.OK);
    }
}
