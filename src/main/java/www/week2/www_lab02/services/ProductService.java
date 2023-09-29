package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.models.Product;
import www.week2.www_lab02.repositories.ProductReponsitory;

@Path("/product")
public class ProductService {
    ProductReponsitory productReponsitory = new ProductReponsitory();
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(productReponsitory.getAllProduct()).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(Product product){
        productReponsitory.insertProduct(product);
        return Response.ok(product).build();
    }
    @GET
    @Path("/{productId}")
    @Produces("application/json")
    public Response getEmployeeById(@PathParam("productId") int productId) {
        Product product = productReponsitory.getProductById(productId);
        if (product != null) {
            return Response.ok(product).build();
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
