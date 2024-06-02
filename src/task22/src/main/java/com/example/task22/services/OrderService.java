package com.example.task22.services;

import com.example.task22.DTO.OrderDTO;
import com.example.task22.objects.OrderO;
import com.example.task22.repositories.OrderRepository;
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
        log.info("Order created");
        OrderO orderO = OrderO.builder()
                .orderDate(dto.getOrderDate())
                .build();
        return orderRepository.save(orderO);
    }
    public List<OrderO> readAll(){
        log.info("Find all orders");
        return orderRepository.findAll();
    }

    public OrderO update(OrderO orderO){
        log.info("Order updated");
        return orderRepository.save(orderO);
    }

    public void delete(Long id){
        log.info("Order deleted");
        orderRepository.deleteById(id);
    }
}
