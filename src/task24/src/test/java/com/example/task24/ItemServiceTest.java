package com.example.task24;

import com.example.task24.DTO.ItemDTO;
import com.example.task24.objects.Item;
import com.example.task24.repositories.ItemRepository;
import com.example.task24.services.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;


    @Test
    public void testCreate() {
        ItemDTO dto = new ItemDTO("vase", "12.12.12", 123);
        Item expectedItem = new Item(null, "vase", "12.12.12", 123);

        when(itemRepository.save(any())).thenReturn(expectedItem);

        Item createdFootballer = itemService.create(dto);

        verify(itemRepository, times(1)).save(any());
        assertEquals(expectedItem, createdFootballer);
    }

    @Test
    public void testReadAll() {

        ItemDTO dto1 = new ItemDTO("vase", "12.12.12", 123);
        Item expectedItem1 = itemService.create(dto1);

        ItemDTO dto2 = new ItemDTO("Glass", "12.11.10", 21);
        Item expectedItem2 = itemService.create(dto2);

        List<Item> expectedItems = Arrays.asList(
                expectedItem1,
                expectedItem2
        );

        when(itemRepository.findAll()).thenReturn(expectedItems);

        List<Item> footballers = itemService.readAll();

        verify(itemRepository, times(1)).findAll();
        assertEquals(expectedItems, footballers);
    }

    @Test
    public void testUpdate() {
        Item item = new Item(null, "vase", "12.12.12", 123);

        when(itemRepository.save(any())).thenReturn(item);

        Item updatedItem = itemService.update(item);

        verify(itemRepository, times(1)).save(any());
        assertEquals(item, updatedItem);
    }

    @Test
    public void testDelete() {
        Long id = 1L;

        itemService.delete(id);

        verify(itemRepository, times(1)).deleteById(id);
    }
}
