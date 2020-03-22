package org.wirvsvirushackathon.helpado.services.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.order.api.Order;
import org.wirvsvirushackathon.helpado.order.storage.OrderStorage;
import org.wirvsvirushackathon.helpado.services.order.api.OrderCreateRequest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/order-service/v1")
@Produces(MediaType.APPLICATION_JSON)
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderStorage orderStorage;

    public OrderService(OrderStorage orderStorage) {
        logger.info("Constructing OrderService with storage type {} ", orderStorage.getClass());
        this.orderStorage = orderStorage;
    }

    @PUT
    @Path("/orders")
    public Response createOrder(OrderCreateRequest orderCreateRequest) {
        logger.info("The creation of an order has been requested");

        Optional<String> createdOrderId = orderStorage.createOrder(
                orderCreateRequest.getOrderedItems(),
                orderCreateRequest.getPremiumProducts(),
                orderCreateRequest.getLatestDeliveryWished(),
                "userIdToBeDone"
        );
        if (createdOrderId.isPresent()) {
            return Response.status(Response.Status.CREATED).entity(createdOrderId.get()).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
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
