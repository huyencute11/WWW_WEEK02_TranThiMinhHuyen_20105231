package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.models.ProductImage;
import www.week2.www_lab02.repositories.ProductImageReponsitory;

@Path("/productImage")
public class ProductImageService {
    ProductImageReponsitory productImageReponsitory = new ProductImageReponsitory();
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(productImageReponsitory.getAllProductImage()).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(ProductImage productImage){
        productImageReponsitory.insertProductImage(productImage);
        return Response.ok(productImage).build();
    }
    @GET
    @Path("/{productImageId}")
    @Produces("application/json")
    public Response getProductImageById(@PathParam("productImageId") int productImageId) {
        ProductImage productImage = productImageReponsitory.getProductImageById(productImageId);
        if (productImage != null) {
            return Response.ok(productImage).build();
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
