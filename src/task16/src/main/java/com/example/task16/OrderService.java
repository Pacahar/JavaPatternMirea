package com.example.task16;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class OrderService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public List<Order> getOrders() {
        return session.createQuery("from Order", Order.class).getResultList();
    }

    public void saveOrUpdateOrder(Order order) {
        session.beginTransaction();
        session.saveOrUpdate(order);
        session.getTransaction().commit();
    }

    public Order getOrderById(Long id){
        List<Order> orders = getOrders();
        for (Order order: orders){
            if (Objects.equals(order.getId(), id))
                return  order;
        }
        return null;
    }
}

