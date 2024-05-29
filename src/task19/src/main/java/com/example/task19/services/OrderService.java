package com.example.task19.services;

import com.example.task19.DTO.OrderDTO;
import com.example.task19.objects.OrderO;
import com.example.task19.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderO create(OrderDTO dto){
        OrderO orderO = OrderO.builder()
                .orderDate(dto.getOrderDate())
                .build();
        return orderRepository.save(orderO);
    }
    public List<OrderO> readAll(){
        return orderRepository.findAll();
    }

    public OrderO update(OrderO orderO){
        return orderRepository.save(orderO);
    }

    public void delete(Long id){
        orderRepository.deleteById(id);
    }
}
