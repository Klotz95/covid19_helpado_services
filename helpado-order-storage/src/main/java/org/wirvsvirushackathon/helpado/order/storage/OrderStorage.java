package org.wirvsvirushackathon.helpado.order.storage;

import org.jvnet.hk2.annotations.Service;
import org.wirvsvirushackathon.helpado.order.api.OrderItem;
import org.wirvsvirushackathon.helpado.order.api.Order;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface OrderStorage {

    /**
     * @return a List containing all {@link Order}s currently saved at the
     * {@link OrderStorage}
     */
    List<Order> getAllOrders();

    /**
     * Saves a {@link Order} to the {@link OrderStorage} having the specified parameter
     * @param orderedItems which are included in the {@link Order}
     * @param latestDeliveryWished of the {@link org.eclipse.jetty.server.Authentication.User} who created the order
     * @param createdByUserId contains the id of the user who creates this {@link Order}
     *
     * @return the order ID
     */
    Optional<String> createOrder(List<OrderItem> orderedItems, Date latestDeliveryWished, String createdByUserId);

    /**
     * Returns the {@link Order} having the specified id
     * @param id of the {@link Order}
     *
     * @return an {@link Optional} containing the {@link Order} having the specified id
     * if existing
     */
    Optional<Order> getOrderById(String id);

    /**
     * Update the latest delivery wished parameter of the {@link Order} having the specified id
     *  @param orderId of the {@link Order} wish delivery wished parameter need to get changed
     * @param userId
     * @param latestDeliveryWished which should be set to the {@link Order}
     */
    void updateLatestDeliveryWishedOfOrder(String orderId, String userId, Date latestDeliveryWished);

    /**
     * Updates the budget information of the {@link Order} having the specified id
     *  @param orderId of the {@link Order} which budget should get changed
     * @param userId
     * @param budget which should be saved for the {@link Order}
     */
    void updateBudgetOfOrder(String orderId, String userId, float budget);

    /**
     * Updates the item list of the {@link Order} having the specified id
     * @param orderId of the {@link Order} which item list should get changed
     * @param userId of the user who wants to change the order
     * @param orderItems which should be saved for the {@link Order}
     */
    void updateItemListOfOrder(String orderId, String userId, List<OrderItem> orderItems);

    /**
     * Updates the assigned to of the {@link Order} having the specified id
     *
     * @param orderId of the {@link Order} which assignedTo should get changed
     * @param assignedToUserId
     */
    void updateAssignedToOfOrder(String orderId, String assignedToUserId);

    void updateEstimatedDeliveryAtOfOrder(String orderId, Date estimatedDelivery);

}
