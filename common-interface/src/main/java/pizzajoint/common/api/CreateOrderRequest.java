package pizzajoint.common.api;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author raychong
 */
public class CreateOrderRequest {
    @NotNull
    public String pizzaName;

    @NotNull
    @Min(value = 1)
    public Integer quantity;

    @NotNull
    public BigDecimal price;
}
