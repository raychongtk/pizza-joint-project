package com.pizzajoint.pizzaapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pizzajoint.common.api.CreateOrderRequest;
import pizzajoint.common.api.CreateOrderResponse;

import java.math.BigDecimal;

/**
 * @author raychong
 */
@RestController
@RequestMapping("pizza")
public class GeneratePizzaController {
    @PostMapping
    public void createPizzaOrder() {
        String url = "http://order-service:8080/order";
        var request = new CreateOrderRequest();
        request.pizzaName = "pizza";
        request.quantity = 1;
        request.price = BigDecimal.TEN;

        CreateOrderResponse response = new RestTemplate().postForObject(url, request, CreateOrderResponse.class);
        System.out.println(response.success);
    }
}
