package com.example.task21.services;

import com.example.task21.DTO.OrderDTO;
import com.example.task21.objects.OrderO;
import com.example.task21.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public OrderO create(OrderDTO dto){
        log.info("Order created");
        OrderO orderO = OrderO.builder()
                .orderDate(dto.getOrderDate())
                .build();
        return orderRepository.save(orderO);
    }

    @Transactional(readOnly = true)
    public List<OrderO> readAll(){
        log.info("Find all orders");
        return orderRepository.findAll();
    }

    @Transactional
    public OrderO update(OrderO orderO){
        log.info("Order updated");
        return orderRepository.save(orderO);
    }

    @Transactional
    public void delete(Long id){
        log.info("Order deleted");
        orderRepository.deleteById(id);
    }
}
