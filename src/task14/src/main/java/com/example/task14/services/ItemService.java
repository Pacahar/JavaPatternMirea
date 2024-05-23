package com.example.task14.services;

import com.example.task14.objects.Item;
import com.example.task14.repositories.IMItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
public class ItemService {
    private final IMItemRepository repository;

    public List<Item> getItems(){
        return repository.getItems();
    }

    public void addItem(String name, String creationDate, Integer price){
        repository.addItem(name, creationDate, price);
    }

    public void deleteItem(String name){
        repository.deleteItem(name);
    }
}
