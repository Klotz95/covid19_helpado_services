package org.wirvsvirushackathon.helpado.order.api;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private List<OrderItem> orderedItems;
    private Boolean premiumProducts;
    private Date latestDeliveryWished;
    private Date estimatedDeliveryAt;
    private Date createdAt;
    private String createdByUserId;
    private String assignedToUserId;
    private Float budget;
    private OrderState state;

    public Order() {
    }

    public Order(String orderId, List<OrderItem> orderedItems, Boolean premiumProducts, Date latestDeliveryWished, Date estimatedDeliveryAt, Date createdAt, String createdByUserId, String assignedToUserId, Float budget, OrderState state) {
        this.orderId = orderId;
        this.orderedItems = orderedItems;
        this.premiumProducts = premiumProducts;
        this.latestDeliveryWished = latestDeliveryWished;
        this.estimatedDeliveryAt = estimatedDeliveryAt;
        this.createdAt = createdAt;
        this.createdByUserId = createdByUserId;
        this.assignedToUserId = assignedToUserId;
        this.budget = budget;
        this.state = state;
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

    public Boolean getPremiumProducts() {
        return premiumProducts;
    }

    public void setPremiumProducts(Boolean premiumProducts) {
        this.premiumProducts = premiumProducts;
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
}
