package org.wirvsvirushackathon.helpado.services.order.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.wirvsvirushackathon.helpado.order.api.Order;
import org.wirvsvirushackathon.helpado.user.api.Address;

public class OrderWithAddress extends Order {
    private static final String USER_ADDRESS_PARAMETER_NAME = "address";

    @JsonProperty(USER_ADDRESS_PARAMETER_NAME)
    private Address address;

    @JsonCreator
    public OrderWithAddress(Order order, Address address) {
        super(order);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
