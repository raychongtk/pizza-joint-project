package pizzajoint.common.api;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * @author raychong
 */
public class CreateOrderRequest {
    @NotNull
    public String pizzaName;

    @NotNull
    public Integer quantity;

    @NotNull
    public BigDecimal price;
}
