package com.example.task24.services;

import com.example.task24.objects.Item;
import com.example.task24.objects.OrderO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

@Slf4j
@Service
public class SchedulingService {
    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderService orderService;

    private void writeItems() {
        List<Item> items = itemService.readAll();
        try {
            RandomAccessFile writer = new RandomAccessFile("backup/items.txt", "rw");
            writer.setLength(0);
            for (Item item : items) {
                String itemStr = String.format("%d %s %s %d\n",
                        item.getId(),
                        item.getName(),
                        item.getCreationDate(),
                        item.getPrice());
                writer.write(itemStr.getBytes());
            }
            writer.close();
            log.info("write items");
        } catch (IOException e) {
            log.error("IOException");
            throw new RuntimeException(e);
        }
    }

    private void writeOrders() {
        List<OrderO> orders = orderService.readAll();
        try {
            RandomAccessFile writer = new RandomAccessFile("backup/orders.txt", "rw");
            writer.setLength(0);
            for (OrderO order : orders) {
                String orderStr = String.format("%d %s \n",
                        order.getId(),
                        order.getOrderDate());
                writer.write(orderStr.getBytes());
            }
            writer.close();
            log.info("write orders");
        } catch (IOException e) {
            log.error("IOException");
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "* */5 * * * *")
    public void makeBackup() {
        writeItems();
        writeOrders();
    }
}
