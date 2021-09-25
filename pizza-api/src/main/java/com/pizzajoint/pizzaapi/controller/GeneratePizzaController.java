package com.pizzajoint.pizzaapi.controller;

import com.pizzajoint.pizzaapi.api.CreatePizzaOrderResponse;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${order-svc.url}")
    private String orderServiceURL;

    @PostMapping
    public CreatePizzaOrderResponse createPizzaOrder() {
        String url = orderServiceURL + "/order";
        var request = new CreateOrderRequest();
        request.pizzaName = "pizza";
        request.quantity = 1;
        request.price = BigDecimal.TEN;

        CreateOrderResponse response = new RestTemplate().postForObject(url, request, CreateOrderResponse.class);
        var ajaxResponse = new CreatePizzaOrderResponse();

        if (response == null) {
            ajaxResponse.success = Boolean.FALSE;
            return ajaxResponse;
        }

        ajaxResponse.orderId = response.orderId;
        ajaxResponse.success = response.success;
        return ajaxResponse;
    }
}
