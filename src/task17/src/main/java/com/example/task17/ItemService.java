package com.example.task17;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

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

    public List<Item> getItemsCriteria(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = builder.createQuery(Item.class);
        Root<Item> root = itemCriteriaQuery.from(Item.class);
        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get("price")));
        Query<Item> query = session.createQuery(itemCriteriaQuery);
        return query.getResultList();

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

