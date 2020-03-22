package org.wirvsvirushackathon.helpado.order.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItem {
    private static final String NAME_PARAMETER_NAME = "name";
    private static final String QUANTITY_PARAMETER_NAME = "quantity";
    private static final String COMMENT_PARAMETER_NAME = "comment";

    @JsonProperty(NAME_PARAMETER_NAME)
    private String name;
    @JsonProperty(QUANTITY_PARAMETER_NAME)
    private String quantity;
    @JsonProperty(COMMENT_PARAMETER_NAME)
    private String comment;

    public OrderItem() {
    }

    public OrderItem(
            String name,
            String quantity,
            String comment
    ) {
        this.name = name;
        this.quantity = quantity;
        this.comment = comment;
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
