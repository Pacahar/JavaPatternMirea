package com.example.task19.services;

import com.example.task19.DTO.ItemDTO;
import com.example.task19.objects.Item;
import com.example.task19.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class ItemService {
    private final ItemRepository itemRepository;

    public Item create(ItemDTO dto){
        Item item = Item.builder()
                .name(dto.getName())
                .creationDate(dto.getCreationDate())
                .price(dto.getPrice())
                .build();
        return itemRepository.save(item);
    }
    public List<Item> readAll(){
        return itemRepository.findAll();
    }

    public Item update(Item item){
        return itemRepository.save(item);
    }

    public void delete(Long id){
        itemRepository.deleteById(id);
    }
}
