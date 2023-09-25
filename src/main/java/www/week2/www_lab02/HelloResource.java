package www.week2.www_lab02;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.models.Employee;
import www.week2.www_lab02.repositories.EmployeeRepository;

@Path("/employees")
public class HelloResource {
    //thiếu api/employees k hiểu cái bài này nó bị gì luôn
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(employeeRepository.getAllEmp()).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(Employee employee){
        employeeRepository.insertEmp(employee);
        return Response.ok(employee).build();
    }
}