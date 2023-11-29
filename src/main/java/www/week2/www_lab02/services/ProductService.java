package www.week2.www_lab02.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.www_lab02.converters.ProductDTO;
import www.week2.www_lab02.models.Product;
import www.week2.www_lab02.models.ProductImage;
import www.week2.www_lab02.models.ProductPrice;
import www.week2.www_lab02.repositories.ProductImageReponsitory;
import www.week2.www_lab02.repositories.ProductPriceReponsitory;
import www.week2.www_lab02.repositories.ProductReponsitory;

import java.util.ArrayList;
import java.util.List;

@Path("/product")
public class ProductService {
    ProductReponsitory productReponsitory = new ProductReponsitory();
    ProductImageReponsitory productImageReponsitory = new ProductImageReponsitory();
    ProductPriceReponsitory productPriceReponsitory = new ProductPriceReponsitory();
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
    @GET
    @Path("/detail")
    @Produces("application/json")
    public Response getProducts() {
        List<ProductDTO> products = new ArrayList<>();

        ProductDTO product = null;
        for (Product p : productReponsitory.getAllProduct()) {
            product = new ProductDTO();
            product.setId(p.getProductID());
            product.setDes(p.getDescription());
            ProductPrice pp = productPriceReponsitory.findMostRecentPriceByProductId(p.getProductID());
            List<ProductImage> ppListImage = productImageReponsitory.getProductImageById(p.getProductID());
            product.setPrice(pp.getPrice());
            List<String> pis = new ArrayList<>();
            for (ProductImage pi : ppListImage){
                pis.add(pi.getPath());
            }
            product.setPathImage(pis);
            product.setName(p.getName());
            products.add(product);
        }
        return Response.ok(products).build();
    }
}
