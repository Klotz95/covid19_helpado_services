package org.wirvsvirushackathon.helpado.order.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Order {

    private static final String ORDER_ID_PARAMETER_NAME = "orderId";
    private static final String ORDERED_ITEMS_PARAMETER_NAME = "orderedItems";
    private static final String ORDER_TYPE_PARAMETER_NAME = "orderType";
    private static final String LATEST_DELIVERY_WISHED_PARAMETER_NAME = "latestDeliveryWished";
    private static final String ESTIMATED_DELIVERY_AT_PARAMETER_NAME = "estimatedDeliveryAt";
    private static final String CREATED_AT_PARAMETER_NAME = "createdAt";
    private static final String CREATED_BY_USER_ID_PARAMETER_NAME = "createdByUserId";
    private static final String ASSIGNED_TO_USER_ID_PARAMETER_NAME = "assignedToUserId";
    private static final String BUDGET_PARAMETER_NAME = "budget";
    private static final String STATE_PARAMETER_NAME = "state";

    @JsonProperty(ORDER_ID_PARAMETER_NAME)
    private String orderId;
    @JsonProperty(ORDERED_ITEMS_PARAMETER_NAME)
    private List<OrderItem> orderedItems;
    @JsonProperty(ORDER_TYPE_PARAMETER_NAME)
    private String orderType;
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

    @JsonCreator
    public Order() {}

    @JsonCreator
    public Order(Order oldOrder) {
        this.orderId = oldOrder.orderId;
        this.orderedItems = oldOrder.orderedItems;
        this.orderType = oldOrder.orderType;
        this.latestDeliveryWished = oldOrder.latestDeliveryWished;
        this.estimatedDeliveryAt = oldOrder.estimatedDeliveryAt;
        this.createdAt = oldOrder.createdAt;
        this.createdByUserId = oldOrder.createdByUserId;
        this.assignedToUserId = oldOrder.assignedToUserId;
        this.budget = oldOrder.budget;
        this.state = oldOrder.state;
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
