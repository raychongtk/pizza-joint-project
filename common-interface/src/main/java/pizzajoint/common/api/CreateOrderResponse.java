package pizzajoint.common.api;

import javax.validation.constraints.NotNull;

/**
 * @author raychong
 */
public class CreateOrderResponse {
    @NotNull
    public String orderId;

    @NotNull
    public Boolean success;
}
