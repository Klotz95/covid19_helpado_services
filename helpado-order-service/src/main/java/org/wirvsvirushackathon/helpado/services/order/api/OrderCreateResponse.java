package org.wirvsvirushackathon.helpado.services.order.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderCreateResponse {

    private static final String ORDER_ID_PARAMETER_NAME = "orderId";

    @JsonProperty(ORDER_ID_PARAMETER_NAME)
    private final String orderId;

    @JsonCreator
    public OrderCreateResponse(@JsonProperty(ORDER_ID_PARAMETER_NAME) String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
