package org.wirvsvirushackathon.helpado.services.order.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.wirvsvirushackathon.helpado.order.api.OrderItem;

import java.util.Date;
import java.util.List;

public class OrderPatchRequest extends OrderCreateRequest {
    private static final String ORDER_ID_PARAMETER_NAME = "orderId";
    private static final String USER_ID_PARAMETER_NAME = "userId";
    private static final String ORDERED_ITEMS_PARAMETER_NAME = "orderedItems";
    private static final String PREMIUM_PRODUCTS_PARAMETER_NAME = "premiumProducts";
    private static final String LATEST_DELIVERY_WISHED_PARAMETER_NAME = "latestDeliveryWished";
    private static final String SESSION_TOKEN_PARAMETER_NAME = "sessionToken";
    private static final String ORDER_TYPE_PARAMETER_NAME = "orderType";
    private static final String BUDGET_PARAMETER_NAME = "budget";

    @JsonProperty(ORDER_ID_PARAMETER_NAME)
    private final String orderId;

    @JsonCreator
    public OrderPatchRequest(
            @JsonProperty(ORDERED_ITEMS_PARAMETER_NAME) List<OrderItem> orderedItems,
            @JsonProperty(PREMIUM_PRODUCTS_PARAMETER_NAME) Boolean premiumProducts,
            @JsonProperty(LATEST_DELIVERY_WISHED_PARAMETER_NAME) Date latestDeliveryWished,
            @JsonProperty(SESSION_TOKEN_PARAMETER_NAME) String sessionToken,
            @JsonProperty(USER_ID_PARAMETER_NAME) String userId,
            @JsonProperty(BUDGET_PARAMETER_NAME) Float budget,
            @JsonProperty(ORDER_TYPE_PARAMETER_NAME) String orderType,
            @JsonProperty(ORDER_ID_PARAMETER_NAME) String orderId) {
        super(orderedItems, premiumProducts, latestDeliveryWished, sessionToken, userId, budget, orderType);
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
