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
        storedOrders = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public List<Order> getAllOrders() {
        return storedOrders;
    }

    @Override
    public Optional<String> createOrder(List<OrderItem> orderedItems, Date latestDeliveryWished, String createdByUserId) {
        String uuid = UUID.randomUUID().toString();

        Order newOrder = new Order();
        newOrder.setOrderId(uuid);
        newOrder.setOrderedItems(orderedItems);
        newOrder.setLatestDeliveryWished(latestDeliveryWished);
        newOrder.setCreatedByUserId(createdByUserId);
        newOrder.setCreatedAt(new Date());
        newOrder.setState(OrderState.OPEN);

        this.storedOrders.add(newOrder);
        return Optional.of(uuid);
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return Optional.empty();
    }

    @Override
    public void updateLatestDeliveryWishedOfOrder(String orderId, Date latestDeliveryWished) {

    }

    @Override
    public void updateDescriptionOfOrder(String orderId, String description) {

    }

    @Override
    public void updateBudgetOfOrder(String orderId, float budget) {

    }

    @Override
    public void updateItemListOfOrder(String orderId, List<OrderItem> orderItems) {

    }

    @Override
    public void updateAssignedToOfOrder(String orderId, String assignedToUserId) {

    }

    @Override
    public void updateEstimatedDeliveryAtOfOrder(String orderId, Date estimatedDelivery) {

    }
}
