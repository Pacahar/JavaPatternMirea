package com.example.task21.repositories;

import com.example.task21.objects.OrderO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderO, Long> {
}
