package com.example.task16;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final OrderService orderService;


    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping
    public void createItem(@RequestBody Item item) {
        item.setOrder(orderService.getOrderById(8L));
        itemService.saveOrUpdateItem(item);
    }


}
