package com.pizzajoint.orderservice.service;

import com.pizzajoint.orderservice.domain.Order;
import com.pizzajoint.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @author raychong
 */
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void create(String pizzaName, BigDecimal price, int quantity) {
        var order = new Order();
        order.id = UUID.randomUUID().toString();
        order.pizzaName = pizzaName;
        order.quantity = quantity;
        order.amount = price.multiply(BigDecimal.valueOf(quantity));
        order.creationTime = ZonedDateTime.now();
        orderRepository.save(order);
    }
}
