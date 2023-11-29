package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.models.Employee;
import www.week2.www_lab02.models.Order;
import www.week2.www_lab02.models.ProductImage;
import www.week2.www_lab02.repositories.OrderReponsitory;
import www.week2.www_lab02.repositories.ProductImageReponsitory;

import java.sql.Date;
import java.util.List;

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
    @GET
    @Path("/report-daily")
    @Produces("application/json")
    public Response getDailyReport(@QueryParam("date") Date date) {
        if (date != null) {
            List<Order> orderList = orderReponsitory.getAllOrderDaily(date);
            if (orderList != null && !orderList.isEmpty()) {
                return Response.ok(orderList).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("No orders found for the specified date.").build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date parameter.").build();
        }
    }
    @GET
    @Path("/report-by-date")
    @Produces("application/json")
    public Response getDateReport(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
        if (startDate != null && endDate != null) {
            List<Order> orderList = orderReponsitory.getAllOrdersInDateRange(startDate, endDate);
            if (orderList != null && !orderList.isEmpty()) {
                return Response.ok(orderList).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("No orders found for the specified date.").build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date parameter.").build();
        }
    }
    @GET
    @Path("/report-by-employee")
    @Produces("application/json")
    public Response getDateReportByEmployee(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate, @QueryParam("employee_id") Long id) {
        if (startDate != null && endDate != null) {
            List<Order> orderList = orderReponsitory.getAllOrdersByEmAndDate(startDate, endDate, id);
            if (orderList != null && !orderList.isEmpty()) {
                return Response.ok(orderList).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("No orders found for the specified date.").build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date parameter.").build();
        }
    }
}
