package com.pizzajoint.pizzaapi.controller;

import com.pizzajoint.pizzaapi.api.CreatePizzaOrderResponse;
import com.pizzajoint.pizzaapi.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pizzajoint.common.api.CreateOrderRequest;
import pizzajoint.common.api.CreateOrderResponse;

import java.math.BigDecimal;

/**
 * @author raychong
 */
@RestController
@RequestMapping("pizza")
public class GeneratePizzaController {
    @Autowired
    OrderClient orderClient;

    @PostMapping
    public CreatePizzaOrderResponse createPizzaOrder() {
        var request = new CreateOrderRequest();
        request.pizzaName = "pizza";
        request.quantity = 1;
        request.price = BigDecimal.TEN;
        CreateOrderResponse response = orderClient.create(request);

        var ajaxResponse = new CreatePizzaOrderResponse();
        ajaxResponse.orderId = response.orderId;
        ajaxResponse.success = response.success;
        return ajaxResponse;
    }
}
