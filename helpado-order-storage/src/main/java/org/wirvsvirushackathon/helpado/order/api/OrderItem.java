package org.wirvsvirushackathon.helpado.order.api;

import java.util.UUID;

public class OrderItem {
    private final String orderItemId;
    private String name;
    private String quantity;
    private String comment;
    private Boolean checked;

    public OrderItem() {
        this.orderItemId = UUID.randomUUID().toString();
        this.checked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
