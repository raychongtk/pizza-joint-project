package com.pizzajoint.orderservice.service;

import com.pizzajoint.orderservice.domain.PizzaOrder;
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

    public String create(String pizzaName, BigDecimal price, int quantity) {
        String orderId = UUID.randomUUID().toString();
        var order = new PizzaOrder();
        order.id = orderId;
        order.pizzaName = pizzaName;
        order.quantity = quantity;
        order.amount = price.multiply(BigDecimal.valueOf(quantity));
        order.createdTime = ZonedDateTime.now();
        orderRepository.save(order);
        return orderId;
    }
}
