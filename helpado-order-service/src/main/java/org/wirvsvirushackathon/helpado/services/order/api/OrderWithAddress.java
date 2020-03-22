package org.wirvsvirushackathon.helpado.services.order.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.wirvsvirushackathon.helpado.order.api.Order;
import org.wirvsvirushackathon.helpado.user.api.UserAddress;

public class OrderWithAddress extends Order {
    private static final String USER_ADDRESS_PARAMETER_NAME = "address";

    @JsonProperty(USER_ADDRESS_PARAMETER_NAME)
    private UserAddress userAddress;

    @JsonCreator
    public OrderWithAddress(Order order, UserAddress userAddress) {
        super(order);
        this.userAddress = userAddress;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}
