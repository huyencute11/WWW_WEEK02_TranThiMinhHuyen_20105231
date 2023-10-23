package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.models.Order;
import www.week2.www_lab02.models.ProductImage;
import www.week2.www_lab02.repositories.OrderReponsitory;
import www.week2.www_lab02.repositories.ProductImageReponsitory;

@Path("/order")
public class OrderService {
    OrderReponsitory orderReponsitory = new OrderReponsitory();
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(orderReponsitory.getAllOrder()).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(Order order){
        orderReponsitory.insertOrder(order);
        return Response.ok(order).build();
    }
    @GET
    @Path("/{orderId}")
    @Produces("application/json")
    public Response getProductImageById(@PathParam("orderId") int orderId) {
        Order order = orderReponsitory.getOrderById(orderId);
        if (order != null) {
            return Response.ok(order).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
