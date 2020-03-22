package org.wirvsvirushackathon.helpado.services.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.order.api.Order;
import org.wirvsvirushackathon.helpado.order.storage.OrderStorage;
import org.wirvsvirushackathon.helpado.services.order.api.OrderCreateRequest;
import org.wirvsvirushackathon.helpado.session.SessionManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/order-service/v1")
@Produces(MediaType.APPLICATION_JSON)
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderStorage orderStorage;
    private final SessionManager sessionManager;

    public OrderService(OrderStorage orderStorage, SessionManager sessionManager) {
        logger.info("Constructing OrderService with storage type {} ", orderStorage.getClass());
        this.orderStorage = orderStorage;
        this.sessionManager = sessionManager;
    }

    /**
     * This REST-call can be used to create a order
     * Before creating the order a validation with the {@link org.wirvsvirushackathon.helpado.session.SessionManager}
     * will take place
     * <p>
     * TODO: Frontend need to send the userId inside the request
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
                    orderCreateRequest.getPremiumProducts(),
                    orderCreateRequest.getLatestDeliveryWished(),
                    orderCreateRequest.getUserId()
            );
            if (createdOrderId.isPresent()) {
                return Response.status(Response.Status.CREATED).entity(createdOrderId.get()).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }

        }

        logger.warn("Unauthorized order creation request by user having id {}", orderCreateRequest.getUserId());
        throw new ForbiddenException();
    }

    @GET
    @Path("/orders")
    public Response getAllOrders() {
        logger.info("A list of all orders are requested");

        Optional<List<Order>> allOrders = orderStorage.getAllOrders();

        if (allOrders.isPresent()) {
            return Response.status(Response.Status.OK).entity(allOrders.get()).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
