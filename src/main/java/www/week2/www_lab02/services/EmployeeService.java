package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.enums.EmployeeStatus;
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
    @GET
    @Path("/{employeeId}")
    @Produces("application/json")
    public Response getEmployeeById(@PathParam("employeeId") int employeeId) {
        Employee employee = employeeRepository.getEmpById(employeeId);
        if (employee != null) {
            return Response.ok(employee).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @POST
    @Path("/update-status/{employeeId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateStatus(@PathParam("employeeId") int employeeId, EmployeeStatus newStatus) {
        Employee employee = employeeRepository.getEmpById(employeeId);
        if (employee != null) {
            employeeRepository.updateStatus(employee, newStatus);
            return Response.ok("Update status successful").build();
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
