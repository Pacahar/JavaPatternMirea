package com.example.task21.controllers;

import com.example.task21.DTO.OrderDTO;
import com.example.task21.objects.OrderO;
import com.example.task21.services.EmailService;
import com.example.task21.services.OrderService;
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
    //@Autowired
    private EmailService emailService;
    @RequestMapping(value="/order", method= RequestMethod.POST)
    public ResponseEntity<OrderO> create(@RequestBody OrderDTO dto){
        emailService.sendSimpleMessage("Order created", "New order was created at " + dto.getOrderDate(), "s.kirill29@gmail.com");
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
