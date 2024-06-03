package com.example.task24;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.example.task24.DTO.OrderDTO;
import com.example.task24.objects.OrderO;
import com.example.task24.repositories.OrderRepository;
import com.example.task24.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreate() {
        OrderDTO orderDTO = new OrderDTO("12.12.1221");
        OrderO order = OrderO.builder().orderDate("12.12.1221").build();

        when(orderRepository.save(any())).thenReturn(order);

        OrderO createdTeam = orderService.create(orderDTO);

        assertNotNull(createdTeam);
        assertEquals("12.12.1221", createdTeam.getOrderDate());
    }

    @Test
    public void testReadAll() {
        List<OrderO> orders = new ArrayList<>();
        orders.add(new OrderO(null,"12.11.10"));
        orders.add(new OrderO(null, "10.11.12"));

        when(orderRepository.findAll()).thenReturn(orders);

        List<OrderO> allOrders = orderService.readAll();

        assertNotNull(allOrders);
        assertEquals(2, allOrders.size());
    }

    @Test
    public void testUpdate() {
        OrderO order = new OrderO(null, "29.11.2004");

        when(orderRepository.save(any())).thenReturn(order);

        OrderO updatedTeam = orderService.update(order);

        assertNotNull(updatedTeam);
        //assertEquals("39.11.2004", updatedTeam.getOrderDate());
        assertEquals("29.11.2004", updatedTeam.getOrderDate());
    }

    @Test
    public void testDelete() {
        Long orderId = 1L;

        orderService.delete(orderId);

        verify(orderRepository, times(1)).deleteById(orderId);
    }
}
