package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.models.OrderDetail;
import www.week2.www_lab02.models.ProductImage;
import www.week2.www_lab02.models.ProductPrice;
import www.week2.www_lab02.repositories.ProductPriceReponsitory;

import java.util.List;

@Path("product-price")
public class ProductPriceService {
    ProductPriceReponsitory productPriceReponsitory = new ProductPriceReponsitory();
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(productPriceReponsitory.getAllProductPrice()).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(ProductPrice productPrice){
        productPriceReponsitory.insertProductPrice(productPrice);
        return Response.ok(productPrice).build();
    }


    @GET
    @Path("/getAllPriceById/{productId}")
    @Produces("application/json")
    public Response findAllPriceByProductId(@PathParam("productId") int productId) {
        List<ProductPrice> productPrice = productPriceReponsitory.findAllPriceByProductId(productId);
        if (productPrice != null) {
            return Response.ok(productPrice).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @GET
    @Path("findOldestPriceByProductId/{productId}")
    @Produces("application/json")
    public Response getProductImageById(@PathParam("productId") int productId) {
        ProductPrice productPrice = productPriceReponsitory.findMostRecentPriceByProductId(productId);
        if (productPrice != null) {
            return Response.ok(productPrice).build();
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
