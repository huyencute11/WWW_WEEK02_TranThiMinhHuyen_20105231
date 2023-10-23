package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.models.Customer;
import www.week2.www_lab02.models.Employee;
import www.week2.www_lab02.repositories.CustomerReponsitory;

@Path("/customer")
public class CustomerService {
    CustomerReponsitory customerReponsitory = new CustomerReponsitory();
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(customerReponsitory.getAllEmp()).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(Customer customer){
        customerReponsitory.insertCust(customer);
        return Response.ok(customer).build();
    }
    @GET
    @Path("/{customerId}")
    @Produces("application/json")
    public Response getEmployeeById(@PathParam("customerId") int customerId) {
        Customer customer = customerReponsitory.getCusById(customerId);
        if (customer != null) {
            return Response.ok(customer).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(Customer customer) {
        customerReponsitory.updateCus(customer);
        return Response.ok(customer).build();
    }

    @GET
    @Path("/hello")
    @Produces("application/json")
    public Response getHello() {
        return Response.ok("Hello").build();

    }
}
