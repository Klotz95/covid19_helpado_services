package org.wirvsvirushackathon.helpado.order.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Date;
import java.util.List;

public class Order {

    private static final String ORDER_ID_PARAMETER_NAME = "orderId";
    private static final String ORDERED_ITEMS_PARAMETER_NAME = "orderedItems";
    private static final String LATEST_DELIVERY_WISHED_PARAMETER_NAME = "latestDeliveryWished";
    private static final String ESTIMATED_DELIVERY_AT_PARAMETER_NAME = "estimatedDeliveryAt";
    private static final String CREATED_AT_PARAMETER_NAME = "createdAt";
    private static final String CREATED_BY_USER_ID_PARAMETER_NAME = "createdByUserId";
    private static final String ASSIGNED_TO_USER_ID_PARAMETER_NAME = "assignedToUserId";
    private static final String BUDGET_PARAMETER_NAME = "budget";
    private static final String STATE_PARAMETER_NAME = "state";
    private static final String DESCRIPTION_PARAMETER_NAME = "description";

    @JsonProperty(ORDER_ID_PARAMETER_NAME)
    private String orderId;
    @JsonProperty(ORDERED_ITEMS_PARAMETER_NAME)
    private List<OrderItem> orderedItems;
    @JsonProperty(LATEST_DELIVERY_WISHED_PARAMETER_NAME)
    private Date latestDeliveryWished;
    @JsonProperty(ESTIMATED_DELIVERY_AT_PARAMETER_NAME)
    private Date estimatedDeliveryAt;
    @JsonProperty(CREATED_AT_PARAMETER_NAME)
    private Date createdAt;
    @JsonProperty(CREATED_BY_USER_ID_PARAMETER_NAME)
    private String createdByUserId;
    @JsonProperty(ASSIGNED_TO_USER_ID_PARAMETER_NAME)
    private String assignedToUserId;
    @JsonProperty(BUDGET_PARAMETER_NAME)
    private Float budget;
    @JsonProperty(STATE_PARAMETER_NAME)
    private OrderState state;
    @JsonProperty(DESCRIPTION_PARAMETER_NAME)
    private String description;

    public Order() {
    }

    @JsonCreator
    public Order(@JsonProperty(ORDER_ID_PARAMETER_NAME) String orderId,
                 @JsonProperty(ORDERED_ITEMS_PARAMETER_NAME) List<OrderItem> orderedItems,
                 @JsonProperty(LATEST_DELIVERY_WISHED_PARAMETER_NAME) Date latestDeliveryWished,
                 @JsonProperty(ESTIMATED_DELIVERY_AT_PARAMETER_NAME) Date estimatedDeliveryAt,
                 @JsonProperty(CREATED_AT_PARAMETER_NAME) Date createdAt,
                 @JsonProperty(CREATED_BY_USER_ID_PARAMETER_NAME) String createdByUserId,
                 @JsonProperty(ASSIGNED_TO_USER_ID_PARAMETER_NAME) String assignedToUserId,
                 @JsonProperty(BUDGET_PARAMETER_NAME) Float budget,
                 @JsonProperty(STATE_PARAMETER_NAME) OrderState state,
                 @JsonProperty(DESCRIPTION_PARAMETER_NAME)String description) {
        this.orderId = orderId;
        this.orderedItems = orderedItems;
        this.latestDeliveryWished = latestDeliveryWished;
        this.estimatedDeliveryAt = estimatedDeliveryAt;
        this.createdAt = createdAt;
        this.createdByUserId = createdByUserId;
        this.assignedToUserId = assignedToUserId;
        this.budget = budget;
        this.state = state;
        this.description = description;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderItem> orderedItems) {
        this.orderedItems = orderedItems;
    }



    public Date getLatestDeliveryWished() {
        return latestDeliveryWished;
    }

    public void setLatestDeliveryWished(Date latestDeliveryWished) {
        this.latestDeliveryWished = latestDeliveryWished;
    }

    public Date getEstimatedDeliveryAt() {
        return estimatedDeliveryAt;
    }

    public void setEstimatedDeliveryAt(Date estimatedDeliveryAt) {
        this.estimatedDeliveryAt = estimatedDeliveryAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getAssignedToUserId() {
        return assignedToUserId;
    }

    public void setAssignedToUserId(String assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }
}
