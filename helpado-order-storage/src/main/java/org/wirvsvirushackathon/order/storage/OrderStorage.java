package org.wirvsvirushackathon.order.storage;

import org.jvnet.hk2.annotations.Service;
import org.wirvsvirushackathon.order.api.Order;
import org.wirvsvirushackathon.order.api.OrderItem;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface OrderStorage {
    Optional<List<Order>> getAllOrders();

    Optional<String> createOrder(List<OrderItem> orderedItems, Boolean premiumProducts, Date latestDeliveryWished, Date createdAt, String createdByUserId);
}
