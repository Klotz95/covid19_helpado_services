package org.wirvsvirushackathon.order.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class OrderStorage implements IOrderStorage {
    public static List<OrderStorage> allOrders = new ArrayList<OrderStorage>();

    public String orderId;
    public String title;
    public String description;
    public float budget;
    public Date createdAt;
    public String createdBy;
    public String assignedTo;
    public List<String> orderedItems; // Use strings until items are implemented
    public String state; // Use a string until OrderStates are implemented
    public Date estimatedDeliveryTime;
    public int rating;

    public OrderStorage(String title, String description, float budget, Date createdAt, String createdBy, List<String> orderedItems, String state) {
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.orderedItems = orderedItems;
        this.state = state;
        allOrders.add(this);
    }

    public List<OrderStorage> getOrders() {
        return allOrders;
    }
}
