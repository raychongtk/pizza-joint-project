package com.pizzajoint.pizzaapi.api;

import javax.validation.constraints.NotNull;

/**
 * @author raychong
 */
public class CreatePizzaOrderResponse {
    public String orderId;

    @NotNull
    public Boolean success;
}
