package www.week2.www_lab02.models;

import jakarta.persistence.*;
import www.week2.www_lab02.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productID;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String unit;
    @Column(name = "manufacturer_name", nullable = false)
    private String manufacturerName;

    @Column(name = "status",nullable = false)
    private ProductStatus productStatus;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImageList;


    @OneToMany
    private List<OrderDetail> orderDetails;

    public Product(Long productID) {
        this.productID = productID;
    }
    public Product() {

    }

    public Product(Long productID, String name, String description, String unit, String manufacturerName, ProductStatus productStatus, List<ProductImage> productImageList, List<OrderDetail> orderDetails) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.productStatus = productStatus;
        this.productImageList = productImageList;
        this.orderDetails = orderDetails;
    }


    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", productStatus=" + productStatus +
                ", productImageList=" + productImageList +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
