package org.wirvsvirushackathon.helpado.order.storage;

import org.jvnet.hk2.annotations.Service;
import org.wirvsvirushackathon.helpado.order.api.OrderItem;
import org.wirvsvirushackathon.helpado.order.api.Order;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface OrderStorage {
    Optional<List<Order>> getAllOrders();

    Optional<String> createOrder(List<OrderItem> orderedItems, Boolean premiumProducts, Date latestDeliveryWished, String createdByUserId);
}
