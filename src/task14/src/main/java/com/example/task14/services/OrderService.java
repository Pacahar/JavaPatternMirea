package com.example.task14.services;

import com.example.task14.objects.Order;
import com.example.task14.repositories.IMOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
public class OrderService {
    private final IMOrderRepository repository;

    public List<Order> getOrders(){
        return repository.getOrders();
    }

    public void addOrder(String orderDate){
        repository.addOrder(orderDate);
    }

    public void deleteOrder(String orderDate){
        repository.deleteOrder(orderDate);
    }
}
