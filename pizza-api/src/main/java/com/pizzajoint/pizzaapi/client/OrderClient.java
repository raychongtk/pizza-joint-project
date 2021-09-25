package com.pizzajoint.pizzaapi.client;

import com.pizzajoint.pizzaapi.config.OrderFeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pizzajoint.common.api.CreateOrderRequest;
import pizzajoint.common.api.CreateOrderResponse;

/**
 * @author raychong
 */
@FeignClient(
        name = "order-client", url = "${order-svc.url}",
        configuration = OrderFeignClientConfiguration.class)
public interface OrderClient {
    @PostMapping("/order")
    CreateOrderResponse create(@RequestBody CreateOrderRequest request);
}
