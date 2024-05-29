package com.example.task18.services;

import com.example.task18.DTO.ItemDTO;
import com.example.task18.objects.Item;
import com.example.task18.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
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
