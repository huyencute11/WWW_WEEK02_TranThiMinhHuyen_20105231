package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.models.Employee;
import www.week2.www_lab02.repositories.EmployeeRepository;

@Path("/employees")
public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(employeeRepository.getAllEmp()).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(Employee employee) {
        employeeRepository.insertEmp(employee);
        return Response.ok(employee).build();
    }
    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(Employee employee) {
        employeeRepository.updateEmp(employee);
        return Response.ok(employee).build();
    }
    @DELETE
    @Path("/{employeeId}")
    @Produces("application/json")
    public Response getEmployeeById(@PathParam("employeeId") int employeeId) {
        Employee employee = employeeRepository.getEmpById(employeeId);
        if (employee != null) {
            return Response.ok("OK").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @POST
    @Path("/{employeeId}")
    @Produces("application/json")
    public Response deleteEmployeeById(@PathParam("employeeId") int employeeId) {
        boolean deleted = employeeRepository.deleteEmployeeById(employeeId);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
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
