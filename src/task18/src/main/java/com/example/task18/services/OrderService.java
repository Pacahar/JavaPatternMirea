package com.example.task18.services;

import com.example.task18.DTO.OrderDTO;
import com.example.task18.objects.OrderO;
import com.example.task18.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
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
