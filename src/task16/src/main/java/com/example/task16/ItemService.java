package com.example.task16;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemService {
    private final SessionFactory sessionFactory;
    private Session session;


    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public List<Item> getItems() {
        return session.createQuery("from Item", Item.class).getResultList();
    }

    public void saveOrUpdateItem(Item item) {
        session.beginTransaction();
        session.saveOrUpdate(item);
        session.getTransaction().commit();
    }

    public Order getOrderByItem(Long itemId){
        return session.createQuery("from Item where id = :id", Item.class).setParameter("id", itemId).getSingleResult().getOrder();
    }
}

