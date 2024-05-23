package com.example.task14.configuration;

import com.example.task14.repositories.IMItemRepository;
import com.example.task14.repositories.IMOrderRepository;
import com.example.task14.services.ItemService;
import com.example.task14.services.OrderService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    @ConditionalOnProperty(name = "db-type", havingValue = "in-memory")
    public ItemService IMItemService(IMItemRepository itemRepository) {
        return new ItemService(itemRepository);
    }

    @Bean
    @ConditionalOnProperty(name = "db-type", havingValue = "in-memory")
    public OrderService IMOrderService(IMOrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }

    @Bean
    @ConditionalOnProperty(name = "db-type", havingValue = "in-memory")
    public IMItemRepository IMItemRepository() {
        return new IMItemRepository();
    }

    @Bean
    @ConditionalOnProperty(name = "db-type", havingValue = "in-memory")
    public IMOrderRepository IMOrderRepository() {
        return new IMOrderRepository();
    }
}
