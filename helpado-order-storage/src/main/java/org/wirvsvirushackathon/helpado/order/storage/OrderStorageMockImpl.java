package org.wirvsvirushackathon.helpado.order.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.order.api.OrderItem;
import org.wirvsvirushackathon.helpado.order.api.Order;
import org.wirvsvirushackathon.helpado.order.api.OrderState;

import java.util.*;

public class OrderStorageMockImpl implements OrderStorage {

    private static final Logger logger = LoggerFactory.getLogger(OrderStorageMockImpl.class);

    private final List<Order> storedOrders;

    public OrderStorageMockImpl() {
        storedOrders = new ArrayList<>();
    }

    @Override
    public Optional<List<Order>> getAllOrders() {
        return Optional.of(storedOrders);
    }

    @Override
    public Optional<String> createOrder(List<OrderItem> orderedItems, Boolean premiumProducts, Date latestDeliveryWished, String createdByUserId) {
        String uuid = UUID.randomUUID().toString();

        Order newOrder = new Order();
        newOrder.setOrderId(uuid);
        newOrder.setOrderedItems(orderedItems);
        newOrder.setPremiumProducts(premiumProducts);
        newOrder.setLatestDeliveryWished(latestDeliveryWished);
        newOrder.setCreatedByUserId(createdByUserId);
        newOrder.setCreatedAt(new Date());
        newOrder.setState(OrderState.OPEN);

        this.storedOrders.add(newOrder);
        return Optional.of(uuid);
    }
}
