package org.wirvsvirushackathon.order.api;

public class OrderItem {
    private String orderItemId;
    private String name;
    private String quantity;
    private String comment;

    public OrderItem(
            String orderItemId,
            String name,
            String quantity,
            String comment
    ) {
        this.orderItemId = orderItemId;
        this.name = name;
        this.quantity = quantity;
        this.comment = comment;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
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
}
