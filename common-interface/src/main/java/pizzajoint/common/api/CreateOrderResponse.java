package pizzajoint.common.api;

import org.jetbrains.annotations.NotNull;


/**
 * @author raychong
 */
public class CreateOrderResponse {
    @NotNull
    public String orderId;

    @NotNull
    public Boolean success;
}
