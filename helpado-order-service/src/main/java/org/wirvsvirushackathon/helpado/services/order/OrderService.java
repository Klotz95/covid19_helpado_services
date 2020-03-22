package org.wirvsvirushackathon.helpado.services.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.order.api.Order;
import org.wirvsvirushackathon.helpado.order.api.OrderItem;
import org.wirvsvirushackathon.helpado.order.storage.OrderStorage;
import org.wirvsvirushackathon.helpado.services.order.api.OrderCreateRequest;
import org.wirvsvirushackathon.helpado.services.order.api.OrderCreateResponse;
import org.wirvsvirushackathon.helpado.services.order.api.OrderDeleteRequest;
import org.wirvsvirushackathon.helpado.services.order.api.OrderWithAddress;
import org.wirvsvirushackathon.helpado.session.SessionManager;
import org.wirvsvirushackathon.helpado.user.storage.UserStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/order-service/v1")
@Produces(MediaType.APPLICATION_JSON)
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderStorage orderStorage;
    private final SessionManager sessionManager;
    private final UserStorage userStorage;

    public OrderService(OrderStorage orderStorage, SessionManager sessionManager, UserStorage userStorage) {
        logger.info("Constructing OrderService with storage type {} ", orderStorage.getClass());
        this.orderStorage = orderStorage;
        this.sessionManager = sessionManager;
        this.userStorage = userStorage;
    }

    /**
     * This REST-call can be used to create a order
     * Before creating the order a validation with the {@link org.wirvsvirushackathon.helpado.session.SessionManager}
     * will take place
     *
     * @param orderCreateRequest send by the frontend
     * @return a status code {@link Response} which will be send to the frontend
     */
    @PUT
    @Path("/orders")
    public Response createOrder(OrderCreateRequest orderCreateRequest) {
        logger.info("The creation of an order has been requested by user having id {}", orderCreateRequest.getUserId());

        if (sessionManager.validateSessionToken(orderCreateRequest.getUserId(), orderCreateRequest.getSessionToken())) {
            Optional<String> createdOrderId = orderStorage.createOrder(
                    orderCreateRequest.getOrderedItems(),
                    orderCreateRequest.getLatestDeliveryWished(),
                    orderCreateRequest.getUserId(),
                    orderCreateRequest.getOrderType(),
                    orderCreateRequest.getBudget());
            if (createdOrderId.isPresent()) {
                OrderCreateResponse orderCreateResponse = new OrderCreateResponse(createdOrderId.get());
                return Response.status(Response.Status.CREATED).entity(orderCreateResponse).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        }

        logger.warn("Unauthorized order creation request by user having id {}", orderCreateRequest.getUserId());
        throw new ForbiddenException();
    }

    @PATCH
    @Path("/orders/{orderId}")
    public Response patchOrderAsCreator(@PathParam("orderId") String orderId, OrderCreateRequest orderPatchRequest) {
        String userId = orderPatchRequest.getUserId();
        String sessionToken = orderPatchRequest.getSessionToken();
        List<OrderItem> orderedItems = orderPatchRequest.getOrderedItems();
        Date latestDeliveryWished = orderPatchRequest.getLatestDeliveryWished();
        String orderType = orderPatchRequest.getOrderType();
        Float budget = orderPatchRequest.getBudget();

        logger.info("The patch of an order has been requested by user having id {}", userId);

        if (!sessionManager.validateSessionToken(userId, sessionToken)) {
            logger.warn("Unauthorized order patch request by user having id {}", userId);
            throw new ForbiddenException();
        }

        if (orderedItems != null) {
            orderStorage.updateItemListOfOrder(orderId, userId, orderedItems);
        }

        if (orderType != null) {
            orderStorage.updateTypeOfOrder(orderId, userId, orderType);
        }

        if (budget != null) {
            orderStorage.updateBudgetOfOrder(orderId, userId, budget);
        }

        if (latestDeliveryWished != null) {
            orderStorage.updateLatestDeliveryWishedOfOrder(orderId, userId, latestDeliveryWished);
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/orders")
    public Response getAllOrders() {
        logger.info("A list of all orders are requested");

        List<Order> allOrders = orderStorage.getAllOrders();

        List<OrderWithAddress> allOrdersWithAddress = allOrders.stream().map(this::addAddressToOrder).collect(Collectors.toList());

        return Response.status(Response.Status.OK).entity(allOrdersWithAddress).build();
    }

    private OrderWithAddress addAddressToOrder(Order order) {
        return this.userStorage.getUser(order.getCreatedByUserId())
                .map(user -> new OrderWithAddress(order, user.getUserAddress()))
                .orElseGet(() -> new OrderWithAddress(order, null));
    }

    @DELETE
    @Path("/orders/{orderId}")
    public Response deleteOrderAsCreator(@PathParam("orderId") String orderId, OrderDeleteRequest orderDeleteRequest) {
        String userId = orderDeleteRequest.getUserId();
        String sessionToken = orderDeleteRequest.getSessionToken();

        if (!sessionManager.validateSessionToken(userId, sessionToken)) {
            logger.warn("Unauthorized order patch request by user having id {}", userId);
            throw new ForbiddenException();
        }

        orderStorage.deleteOrder(orderId, userId);

        return Response.status(Response.Status.OK).build();
    }
}
