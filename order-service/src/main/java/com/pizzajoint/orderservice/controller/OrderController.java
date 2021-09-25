package com.pizzajoint.orderservice.controller;

import com.pizzajoint.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pizzajoint.common.api.CreateOrderRequest;
import pizzajoint.common.api.CreateOrderResponse;

/**
 * @author raychong
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public CreateOrderResponse create(@RequestBody CreateOrderRequest request) {
        orderService.create(request.pizzaName, request.price, request.quantity);

        var response = new CreateOrderResponse();
        response.success = Boolean.TRUE;
        return response;
    }
}
