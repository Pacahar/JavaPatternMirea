package com.example.task14.repositories;

import com.example.task14.objects.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IMItemRepository {
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(String name, String creationDate, Integer price){
        items.add(Item.builder().name(name).creationDate(creationDate).price(price).build())    ;
    }

    public void deleteItem(String name){
        items.removeIf(p -> p.getName().equals(name));
    }
}
