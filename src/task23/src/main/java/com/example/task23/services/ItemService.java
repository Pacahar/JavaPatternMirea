package com.example.task23.services;

import com.example.task23.DTO.ItemDTO;
import com.example.task23.objects.Item;
import com.example.task23.repositories.ItemRepository;
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
        log.info("Item created");
        Item item = Item.builder()
                .name(dto.getName())
                .creationDate(dto.getCreationDate())
                .price(dto.getPrice())
                .build();
        return itemRepository.save(item);
    }
    public List<Item> readAll(){
        log.info("Read all Items");
        return itemRepository.findAll();
    }

    public Item update(Item item){
        log.info("Item updated");
        return itemRepository.save(item);
    }

    public void delete(Long id){
        log.info("Item deleted");
        itemRepository.deleteById(id);
    }
}
