package org.wirvsvirushackathon.helpado.services.order.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.wirvsvirushackathon.helpado.order.api.OrderItem;

import java.util.Date;
import java.util.List;

public class OrderCreateRequest {
    private static final String USER_ID_PARAMETER_NAME = "userId";
    private static final String ORDERED_ITEMS_PARAMETER_NAME = "orderedItems";
    private static final String PREMIUM_PRODUCTS_PARAMETER_NAME = "premiumProducts";
    private static final String LATEST_DELIVERY_WISHED_PARAMETER_NAME = "latestDeliveryWished";
    private static final String SESSION_TOKEN_PARAMETER_NAME = "sessionToken";

    @JsonProperty(ORDERED_ITEMS_PARAMETER_NAME)
    private final List<OrderItem> orderedItems;
    @JsonProperty(PREMIUM_PRODUCTS_PARAMETER_NAME)
    private final Boolean premiumProducts;
    @JsonProperty(LATEST_DELIVERY_WISHED_PARAMETER_NAME)
    private final Date latestDeliveryWished;
    @JsonProperty(SESSION_TOKEN_PARAMETER_NAME)
    private final String sessionToken;
    @JsonProperty(USER_ID_PARAMETER_NAME)
    private final String userId;

    @JsonCreator
    public OrderCreateRequest(
            @JsonProperty(ORDERED_ITEMS_PARAMETER_NAME) List<OrderItem> orderedItems,
            @JsonProperty(PREMIUM_PRODUCTS_PARAMETER_NAME) Boolean premiumProducts,
            @JsonProperty(LATEST_DELIVERY_WISHED_PARAMETER_NAME) Date latestDeliveryWished,
            @JsonProperty(SESSION_TOKEN_PARAMETER_NAME) String sessionToken,
            @JsonProperty(USER_ID_PARAMETER_NAME) String userId) {
        this.orderedItems = orderedItems;
        this.premiumProducts = premiumProducts;
        this.latestDeliveryWished = latestDeliveryWished;
        this.sessionToken = sessionToken;
        this.userId = userId;
    }

    public List<OrderItem> getOrderedItems() {
        return orderedItems;
    }

    public Boolean getPremiumProducts() {
        return premiumProducts;
    }

    public Date getLatestDeliveryWished() {
        return latestDeliveryWished;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public String getUserId() {
        return userId;
    }
}
