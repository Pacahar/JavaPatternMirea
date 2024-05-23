package com.example.task15.services;

import com.example.task15.DTO.OrderDTO;
import com.example.task15.objects.Item;
import com.example.task15.objects.Order;
import com.example.task15.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public Order create(OrderDTO dto){
        Order order = Order.builder()
                .orderDate(dto.getOrderDate())
                .build();
        return orderRepository.save(order);
    }
    public List<Order> readAll(){
        return orderRepository.findAll();
    }

    public Order update(Order order){
        return orderRepository.save(order);
    }

    public void delete(Long id){
        orderRepository.deleteById(id);
    }
}
