package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.models.OrderDetail;
import www.week2.www_lab02.repositories.OrderDetailReponsitory;
import java.util.List;

@Path("/order-detail")
public class OrderDetailService {
    OrderDetailReponsitory orderDetailReponsitory = new OrderDetailReponsitory();
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(orderDetailReponsitory.getAllOrderDetail()).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(OrderDetail orderDetail){
        orderDetailReponsitory.insertOrderDetail(orderDetail);
        return Response.ok(orderDetail).build();
    }
    @POST
    @Path("/insert-order-details")
    @Consumes("application/json")
    @Produces("application/json")
    public Response insertOrderDetails(List<OrderDetail> orderDetails) {
        try {
            orderDetailReponsitory.insertOrderDetails(orderDetails);
            return Response.ok("Order details inserted successfully").build();
        } catch (Exception e) {
            return Response.serverError().entity("Failed to insert order details: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{orderId}")
    @Produces("application/json")
    public Response getProductImageById(@PathParam("orderId") int orderId) {
        List<OrderDetail> orderDetails = orderDetailReponsitory.getListOrderDetailByOrderId(orderId);
        if (orderDetails != null) {
            return Response.ok(orderDetails).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/hello")
    @Produces("application/json")
    public Response getHello() {
        return Response.ok("Hello").build();

    }
}
