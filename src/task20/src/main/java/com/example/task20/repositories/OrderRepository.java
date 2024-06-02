package com.example.task20.repositories;

import com.example.task20.objects.OrderO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderO, Long> {
}
