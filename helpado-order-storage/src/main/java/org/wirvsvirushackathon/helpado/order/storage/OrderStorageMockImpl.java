package org.wirvsvirushackathon.helpado.order.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.order.api.Order;
import org.wirvsvirushackathon.helpado.order.api.OrderItem;
import org.wirvsvirushackathon.helpado.order.api.OrderState;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
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
    public Optional<Order> getOrderById(String orderId) {
        return storedOrders.stream().filter(order -> order.getOrderId()
                .equals(orderId)).findFirst();
    }

    @Override
    public void updateLatestDeliveryWishedOfOrder(String orderId, String userId, Date latestDeliveryWished) {
        Order orderToBeChanged = getOrderToBeChangedWithCreatorAuthorization(orderId, userId);
        orderToBeChanged.setLatestDeliveryWished(latestDeliveryWished);
    }

    @Override
    public void updateBudgetOfOrder(String orderId, String userId, float budget) {
        Order orderToBeChanged = getOrderToBeChangedWithCreatorAuthorization(orderId, userId);
        orderToBeChanged.setBudget(budget);
    }

    @Override
    public void updateItemListOfOrder(String orderId, String userId, List<OrderItem> orderItems) {
        Order orderToBeChanged = getOrderToBeChangedWithCreatorAuthorization(orderId, userId);
        orderToBeChanged.setOrderedItems(orderItems);
    }

    @Override
    public void updateAssignedToOfOrder(String orderId, String assignedToUserId) {

    }

    @Override
    public void updateEstimatedDeliveryAtOfOrder(String orderId, Date estimatedDelivery) {

    }

    private Order getOrderToBeChangedWithCreatorAuthorization(String orderId, String userId) {
        Optional<Order> orderToBeChanged = getOrderById(orderId);

        if(orderToBeChanged.isEmpty()) {
            throw new NotFoundException();
        }

        if(!orderToBeChanged.get().getCreatedByUserId().equals(userId)){
            throw new ForbiddenException();
        }

        return orderToBeChanged.get();
    }
}
