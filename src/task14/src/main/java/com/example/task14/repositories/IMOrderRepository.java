package com.example.task14.repositories;

import com.example.task14.objects.Item;
import com.example.task14.objects.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IMOrderRepository{
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders(){
        return Collections.unmodifiableList(orders);
    }

    public void addOrder(String orderDate){
        orders.add(Order.builder().orderDate(orderDate).build());
    }

    public void deleteOrder(String orderDate){
        orders.removeIf(p -> p.getOrderDate().equals(orderDate));
    }
}
